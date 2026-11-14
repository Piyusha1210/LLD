package Entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Customer {
    private String id;
    private String name;
    private Address address;
    private List<Order> orderHistory;

    public Customer(String name, Address address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.orderHistory = new ArrayList<>();
    }

    public void addOrderHistory(Order order) {
        orderHistory.add(order);
    }
}
