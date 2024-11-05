package transaction.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transaction.comm.Message;
import transaction.comm.MessageTypes;


/**
 * This class represents the proxy that acts on behalf of the transaction server on the client side.
 * It provides an implementation of the coordinator interface to the client, hiding the fact
 * that there is a network in between.
 * From the client's perspective, an object of this class IS the transaction.
 * @author wolfdieterotte
 */
public class TransactionServerProxy implements MessageTypes{

    String host = null;
    int port;

    private Socket serverConnection = null;
    private ObjectOutputStream writeToNet = null;
    private ObjectInputStream readFromNet = null;
    private Integer transactionID = 0;

    
    /**
     * Constructor
     * @param host IP address of the transaction server
     * @param port port number of the transaction server
     */
    TransactionServerProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    
    /**
     * Opens a transaction
     * 
     * @return the transaction ID 
     */
    public int openTransaction() {

        try {
            // open up connection to server
            // ...
            serverConnection = new Socket(host, port);

            writeToNet = new ObjectOutputStream(serverConnection.getOutputStream());
            readFromNet = new ObjectInputStream(serverConnection.getInputStream());
            
            // send OPEN_TRANSACTION message & receive transactionID
            // leave connection open!
            // ...
            Message openTransactionMessage = new Message(OPEN_TRANSACTION);
            writeToNet.writeObject(openTransactionMessage);

            Message responseMessage = (Message) readFromNet.readObject();
            transactionID = (Integer) responseMessage.getContent();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error in openTransaction: " + e.getMessage());
        }

        return transactionID;
    }

    
    /**
     * Requests this transaction to be closed.
     * 
     * @return the status, i.e. either TRANSACTION_COMMITTED or TRANSACTION_ABORTED
     */
    public int closeTransaction() {
        int returnStatus = TRANSACTION_ABORTED;

        // send CLOSE_TRANSACTION message & receive returnStatus
        // shut down connection
        // ...
        try {
            // Send CLOSE_TRANSACTION message to the server
            Message closeTransactionMessage = new Message(CLOSE_TRANSACTION, transactionID);
            writeToNet.writeObject(closeTransactionMessage);

            // Receive the transaction's final status from the server
            Message responseMessage = (Message) readFromNet.readObject();
            returnStatus = responseMessage.getType();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error in closeTransaction: " + e.getMessage());
        } 
        // This was written in for some reason the serverConnection wasnt manually closing....
        finally {
            // Ensure the connection is closed after completing the transaction
            try {
                // garentee the server is closed
                if (serverConnection != null) {
                    serverConnection.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing connection in closeTransaction: " + e.getMessage());
            }
        }

        return returnStatus;
    }

   
    /**
     * Reading a value from an account
     * 
     * @param accountNumber
     * @return the balance of the account
     */
    public int read(int accountNumber) {
        int balance = 0;

        // write READ_REQUEST and receive balance
        // ...
        try {
            // Send READ_REQUEST message to the server with the account number
            Message readRequestMessage = new Message(READ_REQUEST, accountNumber);
            writeToNet.writeObject(readRequestMessage);

            // Receive the balance from the server
            Message responseMessage = (Message) readFromNet.readObject();
            balance = (Integer) responseMessage.getContent();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error in read: " + e.getMessage());
        }

        return balance;
    }

    
/**
 * Writing value to account
 * @param accountNumber
 * @param amount
 * 
 * @return the prior account balance
 */
    public int write(int accountNumber, int amount) {
        int priorBalance = 0;

        // write WRITE_REQUEST and receive prior balance
        // ...
        try {
            // Create a write request message with the account number and amount as content
            Message writeRequestMessage = new Message(WRITE_REQUEST, new int[] { accountNumber, amount });
            writeToNet.writeObject(writeRequestMessage);

            // Receive the prior balance from the server
            Message responseMessage = (Message) readFromNet.readObject();
            priorBalance = (Integer) responseMessage.getContent();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error in write: " + e.getMessage());
        }

        return priorBalance;
    }
}
