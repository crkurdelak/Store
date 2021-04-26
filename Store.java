import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that represents a store.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class Store
{
    private Inventory _inventory;

    /**
     * Creates a new Store object.
     */
    public Store()
    {
        _inventory = new Inventory();
    }

    /**
     * Loads the Store's inventory from a file.
     *
     * Read inventory information from the specified filename and load the inventory. The
     * file will contain many products. The file will be a comma-delimited plain-text file with one
     * inventory line item per line in the file; see below for an example. If any file-handling exceptions
     * are raised (e. g., file not found), the method should abort reading the file and simply result in the
     * store being initialized with an empty inventory
     *
     * @param filename the filename of the text file containing the inventory
     */
    public void loadStore(String filename)
    {
        try
        {
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine())
            {
                processReturn(in.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
    }

    /**
     * Returns this Store's inventory.
     * @return this Store's inventory
     */
    public Inventory getInventory()
    {
        return _inventory;
    }

    /**
     * Returns the given item to this Store, changing the item's quantity in this Store's inventory.
     *
     * The item string shall be in the same format as above when loading the store
     * inventory from file. If we have the product in our inventory, adjust the quantity on hand by
     * adding this return to our inventory. If we do not currently carry the product, accept the return
     * anyway and put it in our inventory. Always return the value "RETURNED". (This reason for this
     * will make more sense in the third version of the store program.)
     *
     * @param item the item to be returned
     * @return the value "RETURNED"
     */
    public String processReturn(String item)
    {
        String[] parts = item.split(",");
        String ID = parts[0];
        int quantity = Integer.parseInt(parts[parts.length - 1]);
        InventoryLineItem lineItem = _inventory.findItemByID(ID);

        if (_inventory.getLineItems().contains(lineItem))
        {
            lineItem.adjustQuantity(quantity);
        }
        else
        {
            String itemType = ID.split("_")[0];

            Product product = null;
            if (itemType.equals("BK"))
            {
                product = new Book(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3], parts[4]);
            }
            else if (itemType.equals("WB"))
            {
                product = new WaterBottle(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
            }
            else if (itemType.equals("FD"))
            {
                product = new FlashDrive(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
            }

            if (product != null)
            {
                _inventory.restock(product, quantity);
            }
        }
        return "RETURNED";
    }

    /**
     * Processes an order by adjusting the inventory quantity of the given item by the given amount.
     *
     *  Process the order if we can, i. e., adjust the corresponding quantity of the specified
     * product in the store’s inventory. The order string shall consist of the product ID and the quantity
     * requested, e. g., "FD_001,2" for a single order requesting two of the flash drives. Return a string
     * precisely matching one of the formats specified below, according to the following rules:
     * ∗ "PROCESSED %d", with the quantity processed, for a successfully-fulfilled order;
     * ∗ "INSUFFICIENT %d OF %d", with the quantity on hand and the quantity requested, respectively,
     * if there is insufficient quantity to fulfill the order;
     * ∗ "OUT OF STOCK", if the quantity on hand is zero or the product does not currently exist in
     * the store’s inventory.
     *
     * @param item the item being ordered from this Store
     *
     * @return
     * "PROCESSED %d", with the quantity processed, for a successfully-fulfilled order;
     * "INSUFFICIENT %d OF %d", with the quantity on hand and the quantity requested, respectively,
     * if there is insufficient quantity to fulfill the order;
     * "OUT OF STOCK", if the quantity on hand is zero or the product does not currently exist in
     * the store’s inventory.
     */
    public String processOrder(String item)
    {
        String returnValue = null;
        String[] parts = item.split(",");
        String ID = parts[0];
        int quantity = Integer.parseInt(parts[1]);
        int result = _inventory.pick(ID, quantity);
        if (result == 0)
        {
            returnValue = String.format("PROCESSED %d", quantity);
        }
        else if (result == -1)
        {
            returnValue = "OUT OF STOCK";
        }
        else
        {
            returnValue = String.format("INSUFFICIENT %d OF %d", result, quantity);
        }
        return returnValue;
    }

    /**
     * Returns an array containing instances of the specified product type that
     * are found in the inventory. If no matching products are found, returns an empty array.
     *
     * @param productType the type of product being searched for in the inventory
     *
     * @return an array containing instances of the specified product type that are found in the inventory
     * If no matching products are found, returns an empty array.
     */
    public Product[] findProductsOfType(String productType)
    {
        // use findItemsOfType()
        InventoryLineItem[] foundItems = _inventory.findItemsOfType(productType);
        Product[] foundProducts = new Product[foundItems.length];
        // item.getProduct()
        for (int i = 0; i < foundItems.length; i++)
        {
            foundProducts[i] = foundItems[i].getProduct();
        }
        return foundProducts;
    }

    /**
     * Saves this Store to a file.
     * @param filename the filename of the file used to save this Store
     */
    public void saveStore(String filename)
    {
        try
        {
            File outputFile = new File(filename);
            PrintWriter pw = new PrintWriter(outputFile);
            InventoryLineItem[] lineItems = _inventory.findItemsOfType("");
            for (int i = 0; i < lineItems.length; i++)
            {
                pw.println(lineItems[i].toString());
            }
            pw.close();
        }
        catch (IOException e)
        {
            System.err.println("IO Exception");
        }
    }

    /**
     * Processes an array of transactions.
     * @param transactions an array of transactions
     * @return an array of messages stating how the transactions went
     */
    public String[] processTransactions(Transaction[] transactions)
    {
        ArrayList<String> messagesArrayList = new ArrayList<String>();
        for (int i = 0; i < transactions.length; i++)
        {
            if (transactions[i].isReturn())
            {
                messagesArrayList.add(this.processReturn(transactions[i].getTransaction()));
            }
            else
            {
                messagesArrayList.add(this.processOrder(transactions[i].getTransaction()));
            }
        }
        String[] messages = new String[messagesArrayList.size()];
        for (int i = 0; i < messages.length; i++)
        {
            messages[i] = messagesArrayList.get(i);
        }

        return messages;
    }

}
