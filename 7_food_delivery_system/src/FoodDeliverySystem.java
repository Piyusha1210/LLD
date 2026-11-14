import Entities.*;
import enums.OrderStatus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliverySystem {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();
    private final Map<String, Restaurant> restaurants = new ConcurrentHashMap<>();
    private final Map<String, DeliveryPartner> deliveryPartners = new ConcurrentHashMap<>();
    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    public FoodDeliverySystem() {}


    public Customer addCustomer(String name, Address address) {
        Customer customer = new Customer(name, address);
        customers.putIfAbsent(customer.getId(), customer);
        return customer;
    }

    public Restaurant addRestaurant(String name, Address address) {
        Restaurant restaurant = new Restaurant(name, address);
        restaurants.putIfAbsent(restaurant.getId(), restaurant);
        return restaurant;
    }

    public DeliveryPartner addDeliveryPartner(String name, Address address) {
        DeliveryPartner deliveryPartner = new DeliveryPartner(name, address);
        deliveryPartners.putIfAbsent(deliveryPartner.getId(), deliveryPartner);
        return deliveryPartner;
    }

    public Order createOrder(String customerId, String restaurantId, List<OrderItem> items) {
        // validate customer, restaurant & order Items;
        Customer customer = customers.getOrDefault(customerId, null);
        Restaurant restaurant = restaurants.getOrDefault(restaurantId, null);
        if(customer == null || restaurant == null) {
            return null; // or exception
        }

        Order order = new Order(customer, restaurant, items);
        orders.put(order.getId(), order);
        customer.addOrderHistory(order);
        return order;
    }

    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if(!order.updateOrderStatus(status)) {
            return;
        }
        if(status == OrderStatus.ASSIGNING_DELIVERY_PARTNER) {
            DeliveryPartner partner = getDeliveryPartner();
            order.updateDeliveryPartner(partner);
            order.updateOrderStatus(OrderStatus.OUT_FOR_DELIVERY);
        }

        if(status == OrderStatus.DELIVERED) {
            DeliveryPartner partner = order.getDeliveryPartner();
            partner.updateAvailability();
        }
    }

    private DeliveryPartner getDeliveryPartner() {
        for(DeliveryPartner deliveryPartner: deliveryPartners.values()) {
            if(deliveryPartner.tryAssign()) {
                return deliveryPartner;
            }
        }
        return null;
    }
}
