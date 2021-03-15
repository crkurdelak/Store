/**
 * An abstract class that represents a product in the bookstore.
 *
 * @author ckurdelak20@georgefox.edu
 */
public abstract class Product implements Comparable<Product>
{
    // TODO implement class

    private String _id;
    private String _desc;
    private double _price;

    // TODO write ctor

    /**
     *
     * @return
     */
    public String getID()
    {
        // TODO implement
    }

    /**
     *
     * @return
     */
    public String getDescription()
    {
        // TODO implement
    }

    /**
     *
     * @return
     */
    public double getPrice()
    {
        // TODO implement
        return 0;
    }

    /**
     * Compares this product to some other product.
     *
     * Products are compared based on their prices.
     *
     * @param other the other Product to compare this Product with.
     * @return A negative number if this product's price is less than the other product's price
     *         A positive number if this product's price is greater than the other product's price
     *         else 0 if this product's price is equal to the other product's price
     */
    @Override
    public int compareTo(Product other)
    {
        int result = 0;
        double EPSILON = 1E-6;

        if (Math.abs(this.getPrice() - other.getPrice()) < EPSILON)
        {
            result = 0;
        }
        else if (this.getPrice() < other.getPrice())
        {
            result = -1;
        }
        else if (this.getPrice() > other.getPrice())
        {
            result = 1;
        }

        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        // TODO implement
    }
}

