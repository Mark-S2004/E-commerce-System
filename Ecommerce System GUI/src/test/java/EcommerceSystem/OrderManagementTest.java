package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class OrderManagementTest {
    private OrderManagement orderManagement;

    @BeforeEach
    public void setUp() {
        orderManagement = new OrderManagement();
    }

    @Test
    public void testPlaceOrder() {
        placedOrder order = new placedOrder();
        orderManagement.placeOrder(order);
        List<placedOrder> orders = orderManagement.getAllOrders();
        assertEquals(1, orders.size());
        assertTrue(orders.contains(order));
    }

    @Test
    public void testCancelOrder() {
        placedOrder order = new placedOrder();
        orderManagement.placeOrder(order);
        orderManagement.cancelOrder(order);
        List<placedOrder> orders = orderManagement.getAllOrders();
        assertEquals(0, orders.size());
        assertFalse(orders.contains(order));
    }
}