package state;

import Entities.Order;
import enums.OrderStatus;

public abstract class OrderState {

    public abstract boolean updateOrderState(Order order, OrderStatus status);
}
