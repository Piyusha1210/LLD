import entity.Item;

import java.util.Map;
import java.util.Optional;

public class Inventory {
    private Map<String, Integer> inventory;

    public void addItem(String itemCode, Integer quantity) {
        Integer newQuantity = inventory.get(itemCode) + quantity;
        inventory.put(itemCode, newQuantity);
    }

    public Optional<Integer> isAvailable(String itemCode) {
        return inventory.entrySet().stream()
                .filter(entry -> entry.getKey().equals(itemCode))
                .map(Map.Entry::getValue)
                .findAny();
    }

    public void despenseItem(String itemCode, Integer quantity) {
        Optional<Integer> quantityAvailable = isAvailable(itemCode);
        if(quantityAvailable.isEmpty()) {
            System.out.println("Item with code" + itemCode +" is not available");
            return;
        }
        Integer quantityPresent = isAvailable(itemCode).get();
        if(quantityPresent < quantity) {
            System.out.println("Item with code" + itemCode +" is not available in required quantity");
            System.out.println("Availavle quantity for item" + itemCode + " is " + quantityPresent);
            return;
        }
        Integer newQuantity = inventory.get(itemCode) - quantity;
        inventory.put(itemCode, newQuantity);
    }
}
