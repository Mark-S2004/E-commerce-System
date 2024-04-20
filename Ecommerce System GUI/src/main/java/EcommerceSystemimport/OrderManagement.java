package EcommerceSystemimport;

import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private List<Orders> orders;

    public OrderManagement() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Orders order) {
        orders.add(order);
    }

    public void cancelOrder(Orders order) {
        orders.remove(order);
    }

    public List<Orders> getAllOrders() {
        return orders;
    }
}