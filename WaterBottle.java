/**
 * A subclass of Product that represents a water bottle.
 *
 * @author ckurdelak20@georgefox.edu
 */
public class WaterBottle extends Product
{
    private int _capacity;

    /**
     * Constructs a new WaterBottle object using the given ID, description, price, and capacity.
     * @param id the WaterBottle's ID
     * @param desc the WaterBottle's description
     * @param price the WaterBottle's price
     * @param capacity the WaterBottle's capacity
     */
    public WaterBottle(String id, String desc, double price, int capacity)
    {
        super(id, desc, price);

        _capacity = capacity;
    }

    /**
     * Returns this WaterBottle's capacity.
     * @return this WaterBottle's capacity
     */
    public int getCapacity()
    {
        return _capacity;
    }

    /**
     * Returns a String describing this WaterBottle.
     *
     * Example: "ID: WB_001, Description: HydroFlask w/Sport Lid, Navy Blue, Price: 49.99,
     *          Capacity: 40"
     *
     * @return a String describing this WaterBottle
     */
    @Override
    public String toString()
    {
        return String.format("%s,  Capacity: %d", super.toString(), _capacity);
    }
}

