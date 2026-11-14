package state;

import Entities.Order;
import enums.OrderStatus;

public class PreparingState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        if(status != OrderStatus.ASSIGNING_DELIVERY_PARTNER) {
            System.out.println("order state " + status + " not allowed");
            return false;
        }
        order.setState(new AssigningState());
        return true;
    }
}
