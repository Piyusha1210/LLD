package Entities;

import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Item {
    private String itemId;
    private String itemName;
    private AtomicBoolean isAvailable;
    private Double price;
    private AtomicInteger quanity;

    public Item(String itemName, Double price) {
        this.itemId = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.price = price;
        this.isAvailable = new AtomicBoolean(true);
    }

    public void updateItemAvailability(Boolean isAvailable) {
        this.isAvailable.set(isAvailable);
    }

    public void updateItemPrice(Double price) {
        this.price = (price);
    }

    public synchronized boolean isItemAvailable() {
        return this.isAvailable.get();
    }

    public void updateQuantity(int quan) {
        int result = quanity.updateAndGet(current -> current > quan ? current-quan : current);
    }
}
