package EcommerceSystem;

import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private final List<Order> orders=new ArrayList<Order>();

    public OrderManagement() {

    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("order added");
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}