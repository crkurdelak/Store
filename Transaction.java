import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that represents a transaction.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class Transaction
{
    private String _transaction;
    private boolean _isReturn;

    /**
     * Creates a new Transaction object.
     * @param transaction the transaction string
     */
    public Transaction(String transaction)
    {
        String[] parts = transaction.split(",");
        if (parts.length > 2)
        {
            _isReturn = true;
        }
        else
        {
            _isReturn = false;
        }
        _transaction = transaction;
    }

    /**
     * Returns the transaction string.
     * @return the transaction string
     */
    public String getTransaction()
    {
        return _transaction;
    }

    /**
     * Returns true if the transaction is a return; else, returns false.
     * @return true if the transaction is a return
     * else, returns false
     */
    public boolean isReturn()
    {
        return _isReturn;
    }

    /**
     * Loads an array of Transaction objects from a file.
     * @param filename the filename of the transaction file
     * @return an array of Transaction objects
     */
    public static Transaction[] loadTransaction(String filename)
    {
        ArrayList<Transaction> transactionsArrayList = new ArrayList<Transaction>();
        try
        {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine())
            {
                Transaction t = new Transaction(s.nextLine());
                transactionsArrayList.add(t);
            }
        }
        catch (FileNotFoundException e)
        {
            // do nothing, just don't crash
        }

        Transaction[] transactions = new Transaction[transactionsArrayList.size()];
        for (int i = 0; i < transactions.length; i++)
        {
            transactions[i] = transactionsArrayList.get(i);
        }

        return transactions;
    }
}
