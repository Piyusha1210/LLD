package Entities;

import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class Restaurant {

    private String id;
    private String name;
    private Menu menu;
    private AtomicBoolean isOperational;
    private Address address;

    public Restaurant(String name, Address address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.menu = new Menu();
        this.isOperational = new AtomicBoolean(true);
        this.address = address;
    }

    public void addMenuItem(Item item) {
        this.menu.addMenuItem(item);
    }
}
