package transaction.server.transaction;

import transaction.server.TransactionServer;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author wolfdieterotte
 */
public class Transaction {

	// transaction ID and OCC specific transaction numbers
	int transactionID;
	int transactionNumber;
	int lastAssignedTransactionNumber;

	// the sets of tentative data
	ArrayList<Integer>         readSet = new ArrayList<>();
	HashMap<Integer, Integer> writeSet = new HashMap<>();

	StringBuffer log = new StringBuffer("");


	Transaction(int transactionID, int lastCommittedTransactionNumber)
        {
            // save the transactionID and lastAssignedTransactionNumber
            // the latter is at the very foundation to make the whole OCC work!
            this.transactionID = transactionID;
            this.lastAssignedTransactionNumber = lastCommittedTransactionNumber;
	}

        
	public int read(int accountNumber) {
        Integer balance;

        // Check if the account number is in the writeSet
        if (writeSet.containsKey(accountNumber)) {
            // If it is, get the modified balance
            balance = writeSet.get(accountNumber);
        } else {
            // If not, read the committed version from AccountManager
            balance = TransactionServer.accountManager.read(accountNumber);
        }

        // Add account number to readSet if it's not already present
        if (!readSet.contains(accountNumber)) {
            readSet.add(accountNumber);
        }

        return balance;
    }


	public int write(int accountNumber, int newBalance) {
        int oldBalance;

        // First, get the current balance (either from writeSet if previously modified or from AccountManager)
        if (writeSet.containsKey(accountNumber)) {
            oldBalance = writeSet.get(accountNumber); // Use modified balance if already written in this transaction
        } else {
            oldBalance = TransactionServer.accountManager.read(accountNumber); // Use committed balance otherwise
        }

        // Put <accountNumber, newBalance> in writeSet (this may overwrite prior writes to this account in the transaction)
        writeSet.put(accountNumber, newBalance);

        return oldBalance;

	}


	public ArrayList<Integer> getReadSet() {
        return readSet;
    }


	public HashMap<Integer, Integer> getWriteSet() {
        return writeSet;
    }


	public int getTransactionID() 
        {
            return transactionID;
	}


	public int getTransactionNumber() 
        {
            return transactionNumber;
	}


	public void setTransactionNumber(int transactionNumber) 
        {
            this.transactionNumber = transactionNumber;

	}


	public int getLastAssignedTransactionNumber() 
        {
            return lastAssignedTransactionNumber;
	}


	public void log (String logString) 
        {
            int messageCount = TransactionServer.getMessageCount();

            log.append("\n").append(messageCount).append(" ").append(logString);

            if (!TransactionServer.transactionView) 
            {
                System.out.println(messageCount + " Transaction #" + transactionID + " " + logString);            
            }
	}

	public String getLog()
        {
            return log.toString();
	}
}
