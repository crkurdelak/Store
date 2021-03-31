import java.util.ArrayList;

/***
 * A class that represents the inventory of a store.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class Inventory
{
    // TODO implement Inventory
    private ArrayList<InventoryLineItem> _lineItems;

    /**
     * Creates a new Inventory object.
     */
    public Inventory()
    {
        _lineItems = new ArrayList<InventoryLineItem>();
    }

    /**
     * Returns this Inventory's line items.
     * @return this Inventory's line items
     */
    public ArrayList<InventoryLineItem> getLineItems()
    {
        return _lineItems;
    }

    /**
     * Returns the InventoryLineItem object from the inventory that contains the product with the specified product ID.
     * If the product does not exist, returns null.
     * @param productID the ID of the product being searched for
     * @return the InventoryLineItem object from the inventory that contains the product with the specified product ID.
     * If the product does not exist, returns null // TODO find out how to format this comment
     */
    public InventoryLineItem findItemByID(String productID)
    {
        // TODO test findItemByID
        InventoryLineItem foundItem = null;
        for (InventoryLineItem item : _lineItems)
        {
            if (item.getProduct().getID().equals(productID))
            {
                foundItem = item;
            }
        }

        return foundItem;

        /*
        ILI foundItem = null;
        for each item in _lineItems: // TODO use a while loop so you can stop early
            if item's product's product ID equals productID:
            if (item.getProduct().getID().equals(productID))
                found it
                foundItem = item

        while loop version:
        boolean found = false;
        while _lineItems still has another item and haven't found item yet:
        while count <= _lineItems.size and !found:
            count ++;
            .....

        return foundItem;
         */
    }

    /**
     * Returns an array of InventoryLineItem that have a product of the specified
     * product type. If no matching line items are found, returns an empty array.
     *
     * Per the earlier spec,
     * the product type is a two-letter code that indicates the type of product (BK for books, FD for flash
     * drives, WB for water bottles).
     *
     * @param productType The type of product being searched for
     * @return an array of InventoryLineItem that have a product of the specified
     * product type. If no matching line items are found, returns an empty array. // TODO find out how to format this comment
     */
    public InventoryLineItem[] findItemsOfType(String productType)
    {
        // TODO implement findItemsOfType
        return null;
    }

    /**
     * Given a product ID, return the quantity in stock for the specified product.
     * @param productID The ID of the product whose quantity is being retrieved
     * @return the quantity in stock for the specified product
     */
    public int getQuantityByID(String productID)
    {
        // TODO implement getQuantityByID
        // run findItemByID()
        // item.getQuantity()
        return 0;
    }

    /**
     * Put the specified quantity of the product back into inventory.
     *
     * If the product already
     * exists in the inventory, simply adjust the quantity; else, create a new line item and add it to the
     * inventory. Return the newly-updated quantity on hand after restocking.
     *
     * @param product the product being restocked
     * @param quantity the quantity of the product to be added to the inventory
     * @return the newly-updated quantity on hand after restocking
     */
    public int restock(Product product, int quantity)
    {
        // TODO test restock
        // call findItemByID()
        /*
        try to find the product (by productID)
        if found:
            item.adjustQty(qty);
        else:
            item =  new ILI(product, qty);
            _lineItems.add(item);
         */
        InventoryLineItem item = findItemByID(product.getID());
        if (item != null)
        {
            item.adjustQuantity(quantity);
        }
        else
        {
            item =  new InventoryLineItem(product, quantity);
            _lineItems.add(item);
        }

        return item.getQuantity();
    }

    /**
     * Given a product ID, remove the specified quantity of the specified product from inventory
     * if we have enough product for the entire pick.
     *
     * Return an integer value according to the following:
     * 0, if the specified quantity can be picked successfully;
     * -1, if the specified product is not in stock or not found in the inventory;
     * the quantity we have on hand, if the specified quantity requested is more than we currently
     * have on hand.
     *
     * @param productID the ID of the product to be removed from the inventory
     * @param quantity the quantity of the product to be removed from the inventory
     * @return an integer value according to the following:
     *      * 0, if the specified quantity can be picked successfully;
     *      * -1, if the specified product is not in stock or not found in the inventory;
     *      * the quantity we have on hand, if the specified quantity requested is more than we currently
     *      * have on hand. // TODO find out how to format this comment
     */
    public int pick(String productID, int quantity)
    {
        // TODO test pick
        int returnValue = -1;
        InventoryLineItem item = findItemByID(productID);
        // use findItemByID
        // if findItemByID:
        if (_lineItems.contains(item))
        {
            int itemQuantity = item.getQuantity();
            if (itemQuantity >= quantity)
            {
                item.adjustQuantity(-quantity);
                returnValue = 0;
            }
            //      if item.quantity >= quantity:
            //          item.adjustQuantity(-quantity)
            //          returnValue = 0;
            else if (itemQuantity > 0)
            {
                returnValue = itemQuantity;
                item.adjustQuantity(-itemQuantity);
            }
            //      else if item.quantity < quantity && item.quantity > 0:
            //          returnValue = item.quantity
            //          item.adjustQuantity(item.quantity)
        }

        return returnValue;
    }

    /**
     * Return the value of our entire inventory
     *
     * (i. e., the sum of the line item
     * subtotals), assuming someone walked in and bought the whole inventory.
     *
     * @return the value of the entire inventory
     */
    public double calcInventoryValue()
    {
        // TODO implement calcInventoryValue
        return 0;
    }

}
