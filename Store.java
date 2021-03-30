import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that represents a store.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class Store
{
    // TODO implement Store
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
        // TODO test loadStore

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
            System.out.println("File not found."); // TODO find out how to handle this properly
        }

        // try:
        //      open filename
        //      for each line:
        //          process return(line)
        // catch FileNotFoundException
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
        // TODO implement processReturn

        String[] parts = item.split(",");
        String ID = parts[0];
        String quantity = parts[parts.length - 1];

        //if (_inventory.) // TODO find out how to access _inventory

        // split item string by commas -> parts
        // ID = first part
        // quantity = last part

        // if findItemByID()
        //      adjustQuantity
        // else:
        //      String.split(",") -> String[]
        //      or
        //      Scanner s = new Scanner(item);
        //      s.useDelimiter(",");
        //      s.next()

        //      based on product ID, create new Product of that type
        //      "BK_001"
        //      .split("_")
        //      .startsWith("BK")
        //      .subString(0, 2)

        //      if BK:
        //          product = new Book()
        //      else if WB:
        //          product = new WB()
        //      else if FD:
        //          product = new FD()

        //      restock(product, quantity)

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
     * @return
     * "PROCESSED %d", with the quantity processed, for a successfully-fulfilled order;
     * "INSUFFICIENT %d OF %d", with the quantity on hand and the quantity requested, respectively,
     * if there is insufficient quantity to fulfill the order;
     * "OUT OF STOCK", if the quantity on hand is zero or the product does not currently exist in
     * the store’s inventory.  // TODO find out how to format this comment
     */
    public String processOrder(String item)
    {
        // TODO implement processOrder
        // call pick() in Inventory
        return null;
    }

    /**
     * Returns an array containing instances of the specified product type that
     * are found in the inventory. If no matching products are found, returns an empty array.
     * @param productType the type of product being searched for in the inventory
     * @return an array containing instances of the specified product type that are found in the inventory
     * If no matching products are found, returns an empty array. // TODO find out how to format this comment
     */
    public Product[] findProductsOfType(String productType)
    {
        // TODO implement findProductsofType
        // use findItemsOfType()
        // item.getProduct()
        return null;
    }

}
