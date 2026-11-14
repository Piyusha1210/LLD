package Entities;

import enums.OrderStatus;
import lombok.Getter;
import state.OrderState;
import state.PendingState;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final String id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> orderItems;
    private DeliveryPartner deliveryPartner;
    private OrderStatus status;
    private OrderState orderState;

    public Order(Customer customer, Restaurant restaurant, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItems = items;
        this.deliveryPartner = null;
        this.status = OrderStatus.PENDING;
        this.orderState = new PendingState();
    }

    public boolean updateOrderStatus(OrderStatus status) {
        if(orderState.updateOrderState(this, status)) {
            this.status = status;
            return true;
        }
        return false;
    }

    public void setState(OrderState state) {
        this.orderState = state;
    }

    public void updateDeliveryPartner(DeliveryPartner partner) {
        this.deliveryPartner = partner;
    }
}
