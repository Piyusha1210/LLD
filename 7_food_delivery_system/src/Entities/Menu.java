package Entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Menu {
    Map<String, Item> menuItems;

    public Menu() {
        menuItems = new ConcurrentHashMap<>();
    }

    public void addMenuItem(Item item) {
        menuItems.putIfAbsent(item.getItemId(), item);
    }
}
