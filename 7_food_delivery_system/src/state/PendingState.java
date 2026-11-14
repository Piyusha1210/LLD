package state;

import Entities.Order;
import enums.OrderStatus;

public class PendingState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        if(status != OrderStatus.CONFIRMED && status != OrderStatus.CANCELLED) {
            System.out.println("order state " + status + " not allowed");
            return false;
        }
        if(status == OrderStatus.CANCELLED) {
            order.setState(new CancelledState());
            return true;
        }
        order.setState(new ConfirmedState());
        return true;
    }
}
