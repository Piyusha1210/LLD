package Entities;

import lombok.Getter;

@Getter
public class OrderItem {
    private Item item;
    private Double price;
    private Integer quantity;


    public OrderItem(Item item, Integer quantity) {
        this.item = item;
        this.price = item.getPrice();
        this.quantity = quantity;
    }
}
