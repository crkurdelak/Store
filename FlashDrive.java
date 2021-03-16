/**
 * A subclass of Product that represents a flash drive.
 *
 * @author ckurdelak20@Georgefox.edu
 */
public class FlashDrive extends Product
{
    private int _capacity;

    /**
     * Constructs a new FlashDrive object using the given ID, description, price, and capacity.
     * @param id the FlashDrive's ID
     * @param desc the FlashDrive's description
     * @param price the FlashDrive's price
     * @param capacity the FlashDrive's capacity
     */
    public FlashDrive(String id, String desc, double price, int capacity)
    {
        super(id, desc, price);

        _capacity = capacity;
    }

    /**
     * Returns this FlashDrive's capacity.
     * @return this FlashDrive's capacity
     */
    public int getCapacity()
    {
        return _capacity;
    }

    /**
     * Returns a String describing this FlashDrive.
     *
     * Example: "ID: FD_005, Description: SanDisk Cruzer, Price: 8.99, Capacity: 16"
     *
     * @return a String describing this FlashDrive
     */
    @Override
    public String toString()
    {
        return String.format("%s, Capacity: %d", super.toString(), _capacity);
    }
}

