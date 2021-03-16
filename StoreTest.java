import java.util.ArrayList;

public class StoreTest
{
    public static void main(String[] args)
    {
        ArrayList<InventoryLineItem> items = new ArrayList<>();
        items.add(new InventoryLineItem(new FlashDrive("FD_005", "SanDisk Cruzer", 8.99, 16), 10));

        System.out.toString(items.get(0));
    }
}
