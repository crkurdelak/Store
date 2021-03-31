import java.util.ArrayList;

public class StoreTest
{
    public static void main(String[] args)
    {
        System.out.println("Creating new Store object:");
        Store store = new Store();

        System.out.println("Testing loadStore:");
        store.loadStore("inventory.txt");
        ArrayList<InventoryLineItem> lineItems = store.getInventory().getLineItems();
        for (int i = 0; i < lineItems.size(); i++)
        {
            System.out.println(lineItems.get(i));
        }

        System.out.println("Testing restock:");
        FlashDrive fd1 = new FlashDrive("FD_005", "SanDisk Cruzer", 8.99, 16);
        store.getInventory().restock(fd1, 10);
        System.out.println(store.getInventory().getLineItems());

        System.out.println("Testing findItemByID:");
        System.out.println(store.getInventory().findItemByID("BK_202"));

        System.out.println("Testing pick:");
        System.out.println(store.getInventory().pick("BK_202", 20));
        System.out.println(store.getInventory().pick("WB_001", 20));
        System.out.println(store.getInventory().pick("Bob", 20));
        System.out.println(store.getInventory().pick("WB_001", 20));
        System.out.println(store.getInventory().getLineItems());

        System.out.println("Testing restock:");
        store.getInventory().restock(store.getInventory().findItemByID("WB_001").getProduct(), 10);
        System.out.println(store.getInventory().getLineItems());

        /*
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

        System.out.println("Testing compareTo for Product class:");
        ArrayList<Product> products = new ArrayList<Product>();
        // add products w/ variety of same & different prices
        products.add(wb1);
        products.add(fd1);
        products.add(bk1);
        products.add(new Book("BK_2", "Charlotte's Web", 5.99, "E. B. White", "Scholastic"));
        for (int i = 1; i < products.size(); i++)
        {
            for (int j = 0; j < products.size() - 1; j++)
            {
                if (i != j)
                {
                    System.out.format
                            (
                                    "Comparing %f to %f: %d%n",
                                    products.get(i).getPrice(), products.get(j).getPrice(),
                                    products.get(i).compareTo(products.get(j))
                            );
                }

            }
        }

        System.out.println("Testing compareTo for InventoryLineItem class:");
        ArrayList<InventoryLineItem> lineItems = new ArrayList<InventoryLineItem>();
        // add line items w/ variety of same & different subtotals
        lineItems.add(new InventoryLineItem(fd1, 10));
        lineItems.add(new InventoryLineItem(wb1, 10));
        lineItems.add(new InventoryLineItem(bk1, 10));
        lineItems.add(new InventoryLineItem(new Book("BK_3", "random kids' paperback", 5.99, "person", "random house"), 10));

        for (int i = 1; i < lineItems.size(); i++)
        {
            for (int j = 0; j < lineItems.size() - 1; j++)
            {
                if (i != j)
                {
                    System.out.format
                            (
                                    "Comparing %f to %f: %d%n",
                                    lineItems.get(i).calcSubtotal(), lineItems.get(j).calcSubtotal(),
                                    lineItems.get(i).compareTo(lineItems.get(j))
                            );
                }

            }
        }

        System.out.println("Testing InventoryLineItem ctor with one argument:");
        InventoryLineItem ili1 = new InventoryLineItem(wb1);
        System.out.println(ili1);

         */

    }
}
