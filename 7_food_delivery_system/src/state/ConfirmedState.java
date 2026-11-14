package state;

import Entities.Order;
import enums.OrderStatus;

public class ConfirmedState extends OrderState{

    @Override
    public boolean updateOrderState(Order order, OrderStatus status) {
        if(status != OrderStatus.PREPARING) {
            System.out.println("order state " + status + " not allowed");
            return false;
        }
        order.setState(new PreparingState());
        return true;
    }
}
