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

        // open up connection to server
        // ...
        try{
            serverConnection = new Socket(host,port);
            writeToNet = new ObjectOutputStream(serverConnection.getOutputStream());
            readFromNet = new ObjectInputStream(serverConnection.getInputStream());
        } catch (IOException ex) {
            System.err.println("Error occured when opening object in/out stream");
        }
        
        // send OPEN_TRANSACTION message & receive transactionID
        // leave connection open!
        // ...
        try {
            writeToNet.writeObject(new Message(OPEN_TRANSACTION, null));
            transactionID = (Integer) readFromNet.readObject();
        } catch {
            System.err.println("Error when Writing/reading Message");
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
        try{
            writeToNet.writeObject(new Message(CLOSE_TRANSACTION, null));
            returnStatus = (int) readFromNet.readObject();

            // close all aspects 
            readFromNet.close()
            writeToNet.close()
            serverConnection.close()
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error occured");
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
        try{
            writeToNet.writeObject(new Message(READ_REQUEST, accountNumber));
            balance = (int) readFromNet.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error in Account Number");
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
        int balance = 0;
        
        // write WRITE_REQUEST and receive prior balance
        // ...
        try{
            writeToNet.writeObject(new Message(WRITE_REQUEST, new Object[]{accountNumber, amount}));
            return (int) readFromNet.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error has occured in Write");
        }
        
        return balance;
    }
}
