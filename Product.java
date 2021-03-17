/**
 * An abstract class that represents some product in the bookstore.
 *
 * @author ckurdelak20@georgefox.edu
 */
public abstract class Product implements Comparable<Product>
{
    private String _id;
    private String _desc;
    private double _price;

    private static final double EPSILON = 1E-6;

    /**
     * Constructs a new Product object using the given ID, description, and price.
     * @param id the Product's ID
     * @param desc the Product's description
     * @param price the Product's price
     */
    public Product(String id, String desc, double price)
    {
        _id = id;
        _desc = desc;
        _price = price;
    }

    /**
     * Returns this Product's ID.
     * @return this Product's ID
     */
    public String getID()
    {
        return _id;
    }

    /**
     * Returns this Product's description.
     * @return this Product's description
     */
    public String getDescription()
    {
        return _desc;
    }

    /**
     * Returns this Product's price.
     * @return this Product's price
     */
    public double getPrice()
    {
        return _price;
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
     * Returns a String describing this Product.
     *
     * Example: "ID: FD_005, Description: SanDisk Cruzer, Price: 8.99"
     *
     * @return a String describing this Product
     */
    @Override
    public String toString()
    {
        return String.format("ID: %s, Description: %s, Price: $%.2f", _id, _desc, _price);
    }
}

