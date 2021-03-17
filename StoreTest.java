import java.util.ArrayList;

public class StoreTest
{
    public static void main(String[] args)
    {
        ArrayList<InventoryLineItem> items = new ArrayList<>();
        items.add(new InventoryLineItem(new FlashDrive("FD_005", "SanDisk Cruzer", 8.99, 16), 10));
        items.add(new InventoryLineItem(new Book("BK_202", "Big Java: Early Objects", 99.99, "Cay S. Horstmann", "Wiley"), 70));
        items.add(new InventoryLineItem(new WaterBottle("WB_001", "HydroFlask w/Sport Lid, Navy Blue", 49.99, 40), 5));
        items.add(new InventoryLineItem(new FlashDrive("FD_001", "SanDisk generic example flash drive", 5.99, 8), 25));

        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i));
        }

        System.out.println("Testing get methods:");

        System.out.println("Testing getLineItemNumber:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getLineItemNumber());
        }

        System.out.println("Testing getProduct:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getProduct());
        }

        System.out.println("Testing getQuantity:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getQuantity());
        }

        System.out.println("Testing getID:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getProduct().getID());
        }

        System.out.println("Testing getDescription:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getProduct().getDescription());
        }

        System.out.println("Testing getPrice:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).getProduct().getPrice());
        }

        System.out.println("Testing subclass-specific get methods:");
        FlashDrive fd1 = new FlashDrive("FD_001", "SanDisk generic example flash drive", 5.99, 8);
        WaterBottle wb1 = new WaterBottle("WB_01", "Basic Hydroflask", 49.99, 40);
        Book bk1 = new Book("BK_01", "Generic Book", 50, "John Johnson", "publishy publisher");

        System.out.println(fd1);
        System.out.println(wb1);
        System.out.println(bk1);

        System.out.println(fd1.getCapacity());
        System.out.println(wb1.getCapacity());
        System.out.println(bk1.getAuthor());
        System.out.println(bk1.getPublisher());

        System.out.println("Testing calcDiscountRate:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).calcDiscountRate());
        }

        System.out.println("Testing calcSubtotal:");
        for  (int i = 0; i < items.size(); i ++)
        {
            System.out.println(items.get(i).calcSubtotal());
        }

        // TODO test compareTo
        System.out.println("Testing compareTo:");
        ArrayList<Product> products = new ArrayList<Product>();
        // add products w/ variety of same & different prices

        // TODO test ILI ctor that only takes one argument

        // TODO test Product to make sure it's abstract like it's supposed to be
    }
}
