package transaction.server.transaction;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import transaction.comm.Message;
import transaction.comm.MessageTypes;
import transaction.server.TransactionServer;
import static utils.TerminalColors.ABORT_COLOR;
import static utils.TerminalColors.COMMIT_COLOR;
import static utils.TerminalColors.OPEN_COLOR;
import static utils.TerminalColors.READ_COLOR;
import static utils.TerminalColors.RESET_COLOR;
import static utils.TerminalColors.WRITE_COLOR;


/**
 * Class representing the (singleton) transaction manager
 * @author Dr.-Ing. Wolf-Dieter Otte
 */
public class TransactionManager implements MessageTypes 
{
    // counter for transaction IDs
    private static int transactionIdCounter = 0;
    
    // lists of transactions
    private static final ArrayList<Transaction>        runningTransactions   = new ArrayList<>();
    private static final HashMap<Integer, Transaction> committedTransactions = new HashMap<>();
    private static final ArrayList<Transaction>        abortedTransactions   = new ArrayList<>();
   
    // transaction number counter specific to OCC
    private static int transactionNumberCounter = 0;


    /**
     * Default constructor, nothing to do
     */
    public TransactionManager() {}
    
    
    /**
     * Helper method returning aborted transactions
     * 
     * @return the list of aborted transactions
     */
    public ArrayList<Transaction> getAbortedTransactions()
    {
        return abortedTransactions;
    }

    
    /**
     * Run the transaction for an incoming client request
     * 
     * @param client Socket object representing connection to client
     */
    public synchronized void runTransaction(Socket client) 
    {
        (new TransactionManagerWorker(client)).start();
    }

    
    /**
     * Validates a transaction according to OCC, implementing backwards validation
     * 
     * @param transaction Transaction to be validated
     * @return a flag indicating whether validation was successful
     */
    public boolean validateTransaction(Transaction transaction) {
        int transactionNumber;
        int lastCommittedTransactionNumber = transaction.getLastAssignedTransactionNumber();
        ArrayList<Integer> readSet = transaction.getReadSet();

        // Assign a new transaction number to this transaction
        synchronized (TransactionManager.class) {
            transactionNumber = ++transactionNumberCounter;
        }
        transaction.setTransactionNumber(transactionNumber);

        // Iterate through all transactions with a transaction number greater than the last committed transaction number
        for (int transactionNumberIndex = lastCommittedTransactionNumber + 1; transactionNumberIndex <= transactionNumberCounter; transactionNumberIndex++) {
            Transaction checkedTransaction = committedTransactions.get(transactionNumberIndex);

            // Ensure the transaction with transactionNumberIndex was not aborted and is present in committed transactions
            if (checkedTransaction != null) {
                HashMap<Integer, Integer> checkedTransactionWriteSet = checkedTransaction.getWriteSet();

                // Check for conflicts: if any account in our read set was written by the checked transaction
                for (Integer accountNumber : readSet) {
                    if (checkedTransactionWriteSet.containsKey(accountNumber)) {
                        // Conflict detected: return false
                        transaction.log("[TransactionManager.validateTransaction] Conflict detected with Transaction #" + checkedTransaction.getTransactionID());
                        return false;
                    }
                }
            }
        }

        transaction.log("[TransactionManager.validateTransaction] Transaction #" + transaction.getTransactionID() + " successfully validated");
        return true;
    }
     
    
    /**
     * Writes the write set of a transaction into the operational data
     * 
     * @param transaction Transaction to be written
     */
    public void writeTransaction(Transaction transaction) {
        HashMap<Integer, Integer> transactionWriteSet = transaction.getWriteSet();
        int account;
        int balance;

        // Get all entries in the write set and write them to the operational data (AccountManager)
        for (Map.Entry<Integer, Integer> entry : transactionWriteSet.entrySet()) {
            account = entry.getKey();
            balance = entry.getValue();

            // Write the new balance to the account in AccountManager
            TransactionServer.accountManager.write(account, balance);

            // Log the write operation
            transaction.log("[TransactionManager.writeTransaction] Transaction #" + transaction.getTransactionID() 
                            + " wrote balance $" + balance + " to account #" + account);
        }
    }

    
    /**
     * Objects of this inner class run transactions, one thread runs one transaction
     * on behalf of a client
     */
    public class TransactionManagerWorker extends Thread 
    {
        // networking communication related fields
        Socket client = null;
        ObjectInputStream readFromNet = null;
        ObjectOutputStream writeToNet = null;
        Message message = null;

        // transaction related fields
        Transaction transaction = null;
        int accountNumber       = 0;
        int balance             = 0;

        // flag for jumping out of while loop after this transaction closed
        boolean keepgoing = true;

        
        // the constructor just opens up the network channels
        private TransactionManagerWorker(Socket client) 
        {
            this.client = client;
            // setting up object streams
            try 
            {
                readFromNet = new ObjectInputStream(client.getInputStream());
                writeToNet  = new ObjectOutputStream(client.getOutputStream());
            }
            catch (IOException e)
            {
                System.err.println("[TransactionManagerWorker.run] Failed to open object streams");
                System.exit(1);
            }
        }

        
        @Override
        public void run() 
        {
            // loop is left when transaction closes
            while (keepgoing) 
            {
                // reading message
                try 
                {
                    message = (Message) readFromNet.readObject();
                } 
                catch (IOException | ClassNotFoundException e) 
                {
                    System.out.println("[TransactionManagerWorker.run] Message could not be read from object stream.");
                    System.exit(1);
                }

                // processing message
                switch (message.getType()) 
                {

                    // -------------------------------------------------------------------------------------------
                    case OPEN_TRANSACTION:
                    // -------------------------------------------------------------------------------------------

                        // Synchronize on the runningTransactions to ensure thread safety
                        synchronized (runningTransactions) {
                            // Create a new transaction and assign a new transaction ID
                            int newTransactionID = ++transactionIdCounter;
                            int lastCommittedTransactionNumber = transactionNumberCounter;
                            transaction = new Transaction(newTransactionID, lastCommittedTransactionNumber);

                            // Add the new transaction to the runningTransactions list
                            runningTransactions.add(transaction);
                        }

                        try {
                            // Send the transaction ID back to the client
                            writeToNet.writeObject(new Message(OPEN_TRANSACTION, transaction.getTransactionID()));
                        } catch (IOException e) {
                            System.err.println("[TransactionManagerWorker.run] Failed to send transaction ID to client: " + e.getMessage());
                        }

                        // Log the transaction opening
                        transaction.log("[TransactionManagerWorker.run] " + OPEN_COLOR + "OPEN_TRANSACTION" + RESET_COLOR + " #" + transaction.getTransactionID());

                        break;

                        
                    // -------------------------------------------------------------------------------------------
                    case CLOSE_TRANSACTION:
                    // -------------------------------------------------------------------------------------------
                        synchronized (runningTransactions) {
                            // Remove the transaction from runningTransactions
                            runningTransactions.remove(transaction);

                            // Attempt to validate the transaction
                            if (validateTransaction(transaction)) {
                                // Validation successful, commit the transaction

                                // Add this transaction to committedTransactions
                                committedTransactions.put(transaction.getTransactionNumber(), transaction);

                                // Write the transaction's data to the AccountManager
                                writeTransaction(transaction);

                                // Notify the client that the transaction committed
                                try {
                                    writeToNet.writeObject(new Message(TRANSACTION_COMMITTED, null));
                                } catch (IOException e) {
                                    System.err.println("[TransactionManagerWorker.run] Failed to notify client of transaction commit: " + e.getMessage());
                                }

                                // Log the successful commit
                                transaction.log("[TransactionManagerWorker.run] " + COMMIT_COLOR + "CLOSE_TRANSACTION" + RESET_COLOR + " #" 
                                                + transaction.getTransactionID() + " - COMMITTED");
                            } else {
                                // Validation failed, abort the transaction

                                // Add the transaction to the list of aborted transactions
                                abortedTransactions.add(transaction);

                                // Notify the client that the transaction was aborted
                                try {
                                    writeToNet.writeObject(new Message(TRANSACTION_ABORTED, null));
                                } catch (IOException e) {
                                    System.err.println("[TransactionManagerWorker.run] Failed to notify client of transaction abort: " + e.getMessage());
                                }

                                // Log the aborted transaction
                                transaction.log("[TransactionManagerWorker.run] " + ABORT_COLOR + "CLOSE_TRANSACTION" + RESET_COLOR + " #" 
                                                + transaction.getTransactionID() + " - ABORTED");
                            }
                        }

                        // Close network connections after transaction completion
                        try {
                            readFromNet.close();
                            writeToNet.close();
                            client.close();
                        } catch (IOException e) {
                            System.err.println("[TransactionManagerWorker.run] Error closing connection after CLOSE_TRANSACTION: " + e.getMessage());
                        }

                        // Stop further processing for this transaction
                        keepgoing = false;

                        // Print the transaction log if the transaction view is enabled
                        if (TransactionServer.transactionView) {
                            System.out.println(transaction.getLog());
                        }

                        break;

                        
                    // -------------------------------------------------------------------------------------------
                    case READ_REQUEST:
                    // -------------------------------------------------------------------------------------------
 
                        // Retrieve the account number from the message content
                        accountNumber = (Integer) message.getContent();

                        // Log the pre-read action
                        transaction.log("[TransactionManagerWorker.run] " + READ_COLOR + "READ_REQUEST" + RESET_COLOR + " >>>>>>>>>>>>>>>>>>>> account #" + accountNumber);

                        // Read the balance from the account using the transaction's read method
                        balance = transaction.read(accountNumber);

                        // Send the balance back to the client
                        try {
                            writeToNet.writeObject(new Message(READ_REQUEST, balance));
                        } catch (IOException e) {
                            System.err.println("[TransactionManagerWorker.run] Failed to send balance to client: " + e.getMessage());
                        }

                        // Log the post-read action with the balance obtained
                        transaction.log("[TransactionManagerWorker.run] " + READ_COLOR + "READ_REQUEST" + RESET_COLOR + " <<<<<<<<<<<<<<<<<<<< account #" + accountNumber + ", balance $" + balance);

                        break;

                        
                    // -------------------------------------------------------------------------------------------
                    case WRITE_REQUEST:
                    // -------------------------------------------------------------------------------------------

                        // Retrieve the account number and balance to write from the message content
                        int[] content = (int[]) message.getContent();
                        accountNumber = content[0];
                        balance = content[1];

                        // Log the pre-write action
                        transaction.log("[TransactionManagerWorker.run] " + WRITE_COLOR + "WRITE_REQUEST" + RESET_COLOR + " >>>>>>>>>>>>>>>>>>> account #" + accountNumber + ", balance to write $" + balance);

                        // Write the new balance to the account using the transaction's write method
                        int oldBalance = transaction.write(accountNumber, balance);

                        // Send the old balance back to the client
                        try {
                            writeToNet.writeObject(new Message(WRITE_REQUEST, oldBalance));
                        } catch (IOException e) {
                            System.err.println("[TransactionManagerWorker.run] Failed to send old balance to client: " + e.getMessage());
                        }

                        // Log the post-write action with the new balance written
                        transaction.log("[TransactionManagerWorker.run] " + WRITE_COLOR + "WRITE_REQUEST" + RESET_COLOR + " <<<<<<<<<<<<<<<<<<<< account #" + accountNumber + ", wrote $" + balance);

                        break;

                        
                    // -------------------------------------------------------------------------------------------
                    case ABORT_TRANSACTION:
                    // -------------------------------------------------------------------------------------------
                        
                        // this is a client side abort! ignore ...
                        synchronized (runningTransactions) 
                        {
                            // remove transaction from runningTransactions
                            runningTransactions.remove(transaction);
                        }
                        
                        // shut down
                        try {
                            readFromNet.close();
                            writeToNet.close();
                            client.close();
                            
                            keepgoing = false; //stop loop
                        } catch (IOException e) {
                            System.out.println("[TransactionManagerWorker.run] ABORT_TRANSACTION - Error when closing connection to client");
                        }

                        // add log abort
                        transaction.log("[TransactionManagerWorker.run] " + ABORT_COLOR + "ABORT_TRANSACTION" + RESET_COLOR + " #" + transaction.getTransactionID() + " - ABORTED by client");

                        // final printout of all the transaction's logs
                        if (TransactionServer.transactionView) {
                            System.out.println(transaction.getLog());
                        }
                       
                        break;
                        
                    // -------------------------------------------------------------------------------------------
                    case SHUTDOWN:
                    // -------------------------------------------------------------------------------------------

                        TransactionServer.shutDown();
                        
                        // bail out
                        keepgoing = false;
                        
                        break;                       

                        
                    // -------------------------------------------------------------------------------------------
                    default: // message not implemented
                    // -------------------------------------------------------------------------------------------

                        System.out.println("[TransactionManagerWorker.run] Warning: Message type not implemented");
                }
            }
        }
    }
}
