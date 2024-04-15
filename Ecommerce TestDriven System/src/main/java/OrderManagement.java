import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private List<Order> orders;

    public OrderManagement() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void cancelOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}