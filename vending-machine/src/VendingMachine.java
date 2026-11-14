import entity.Coin;
import entity.Item;

import java.util.Map;

public class VendingMachine {

    public static VendingMachine instance;
    private Inventory inventory;


    protected VendingMachine() {
        inventory = new Inventory();
    }

    public static VendingMachine getInstance() {
        if(instance == null) {
            instance = new VendingMachine();
        }
        return new VendingMachine();
    }

    public void loadItem(String itemCode, Integer quantity) {
        inventory.addItem(itemCode, quantity);
    }

    public void loadMoney(String itemCode, Integer quantity) {
        inventory.addItem(itemCode, quantity);
    }

    public void despenseItem(String itemCode, Integer quantity) {
        inventory.despenseItem(itemCode, quantity);
    }
}
