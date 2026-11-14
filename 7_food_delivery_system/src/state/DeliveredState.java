package state;

import Entities.Order;
import enums.OrderStatus;

public class DeliveredState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        System.out.println("order has delivered, state change not allowed");
        return false;
    }
}
