package main.java;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo{
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public Order addOrder(Order newOrder) {
        orders.add(newOrder);
        return newOrder;
    }

    public void removeOrder(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                return;
            }
        }
    }

    @Override
    public Order updateOrder(Order updatedOrder) {
        return null;
    }
}
