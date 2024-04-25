package EcommerceSystem;

import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private final List<placedOrder> orders=new ArrayList<placedOrder>();

    public OrderManagement() {

    }

    public void placeOrder(placedOrder order) {
        orders.add(order);
        System.out.println("order added");
    }

    public void cancelOrder(placedOrder order) {
        orders.remove(order);
    }

    public List<placedOrder> getAllOrders() {
        return orders;
    }
}