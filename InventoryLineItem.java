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
    // TODO implement class

    // TODO initialize internal state
    private static long _lineItemCount = 0; // DO NOT initialize in the ctor!!
    private long _lineItemNumber;

    /*
    // TODO put this in ctors:
    _lineItemCount ++;
    _lineItemNumber = _lineItemCount
     */

    // TODO implement methods

    /**
     * Calculates this item's subtotal.
     *
     * multiply product's price by quantity
     *
     * @return this item's subtotal
     */
    public double calcSubtotal()
    {
        // TODO implement calcSubtotal
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
        // TODO implement calcDiscountRate
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


}

