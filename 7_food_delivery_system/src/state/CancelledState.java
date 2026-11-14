package state;

import Entities.Order;
import enums.OrderStatus;

public class CancelledState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        System.out.println("order has cancelled, state change not allowed");
        return false;
    }
}
