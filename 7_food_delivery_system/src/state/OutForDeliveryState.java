package state;

import Entities.Order;
import enums.OrderStatus;

public class OutForDeliveryState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        if(status != OrderStatus.CONFIRMED) {
            System.out.println("order state " + status + " not allowed");
            return false;
        }
        order.setState(new ConfirmedState());
        return true;
    }
}
