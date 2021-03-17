/**
 * A class that represents a line item in the bookstore's inventory.
 *
 * Class InventoryLineItem represents a line item in the bookstore’s inventory. A line item has a unique
 * line item number, an associated product, a quantity on hand of that product, and a corresponding
 * discount rate based on the quantity currently on hand (i. e., if we have a lot of an item in stock,
 * give a discount to encourage sales). The line item’s subtotal is calculated based on its product’s
 * price times the quantity, minus the discount.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class InventoryLineItem implements Comparable<InventoryLineItem>
{
    private static long _lineItemCount = 0; // DO NOT initialize in the ctor!!
    private long _lineItemNumber;
    private Product _product;
    private int _quantity;


    /**
     * Constructs a new InventoryLineItem object using the given Product.
     * @param product the Product that this item is // TODO find a better way to word this
     */
    public InventoryLineItem(Product product)
    {
        _lineItemCount ++;
        _lineItemNumber = _lineItemCount;

        _product = product;
    }

    /**
     * Constructs a new InventoryLineItem object using the given product and quantity.
     * @param product the product // TODO find better way to word these
     * @param quantity the quantity of the product
     */
    public InventoryLineItem(Product product, int quantity)
    {
        _lineItemCount ++;
        _lineItemNumber = _lineItemCount;

        _product = product;
        _quantity = quantity;
    }

    /**
     * Returns this item's line item number.
     * @return this item's line item number
     */
    public long getLineItemNumber()
    {
        return _lineItemNumber;
    }

    /**
     * Returns the Product that this item is. // TODO find better wording
     * @return the Product that this item is
     */
    public Product getProduct()
    {
        return _product;
    }

    /**
     * Returns the quantity of this item.
     * @return the quantity of this item
     */
    public int getQuantity()
    {
        return _quantity;
    }

    /**
     * Calculates this item's subtotal.
     *
     * multiply product's price by quantity
     *
     * @return this item's subtotal
     */
    public double calcSubtotal()
    {
        return this.getProduct().getPrice() * this.getQuantity();
    }

    /**
     * Calculates this item's discount rate.
     *
     * Quantity-on-hand-based discount rates are determined as follows: if the quantity on hand is greater than
     * or equal to 10, discount that product by 10%; greater than or equal to 25, discount by 20%; greater than
     * or equal to 50, discount by 25%. Discount rates shall be represented as 0.10 for 10%.
     *
     * @return this item's discount rate
     */
    public double calcDiscountRate()
    {
        double discountRate = 0;
        if (this.getQuantity() >= 50)
        {
            discountRate = 0.25;
        }
        else if (this.getQuantity() >= 25)
        {
            discountRate = 0.20;
        }
        else if (this.getQuantity() >= 10)
        {

            discountRate = 0.10;
        }
        return discountRate;
    }

    /**
     * Compares this InventoryLineItem to some other InventoryLineItem
     *
     * InventoryLineItems are compared based on their subtotals.
     *
     * @param other the other InventoryLineItem to compare this InventoryLineItem with.
     * @return A negative number if this item's subtotal is less than the other item's subtotal
     *         A positive number if this item's subtotal is greater than the other item's subtotal
     *         else 0 if this item's subtotal is equal to the other item's subtotal
     */
    @Override
    public int compareTo(InventoryLineItem other)
    {
        int result = 0;
        double EPSILON = 1E-6;

        if (Math.abs(this.calcSubtotal() - other.calcSubtotal()) < EPSILON)
        {
            result = 0;
        }
        else if (this.calcSubtotal() < other.calcSubtotal())
        {
            result = -1;
        }
        else if (this.calcSubtotal() > other.calcSubtotal())
        {
            result = 1;
        }

        return result;
    }

    /**
     * Returns a String representing this InventoryLineItem.
     *
     * Example: "Line Item Number: 1, Quantity: 10"
     *
     * @return a String representing this InventoryLineItem
     */
    @Override
    public String toString()
    {
        return String.format("Line Item Number: %d, %s, Quantity: %d", _lineItemNumber, _product,
                             _quantity
                            );
    }

}

