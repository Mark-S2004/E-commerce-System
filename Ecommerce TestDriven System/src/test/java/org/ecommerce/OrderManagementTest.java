package org.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderManagementTest {
    private OrderManagement orderManagement;

    @BeforeEach
    public void setUp() {
        orderManagement = new OrderManagement();
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order("O001", "john@example.com");
        orderManagement.placeOrder(order);
        List<Order> orders = orderManagement.getAllOrders();
        assertEquals(1, orders.size());
        assertTrue(orders.contains(order));
    }

    @Test
    public void testCancelOrder() {
        Order order = new Order("O001", "john@example.com");
        orderManagement.placeOrder(order);
        orderManagement.cancelOrder(order);
        List<Order> orders = orderManagement.getAllOrders();
        assertEquals(0, orders.size());
        assertFalse(orders.contains(order));
    }
}