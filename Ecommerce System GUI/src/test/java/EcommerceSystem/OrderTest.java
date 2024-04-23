package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testConstructor() {
        String orderId = "123";
        String userEmail = "test@example.com";

        Orders order = new Orders(orderId, userEmail);

        assertEquals(orderId, order.getOrderId());
        assertEquals(userEmail, order.getUserEmail());
    }

    @Test
    public void testGetOrderId() {
        String orderId = "123";
        String userEmail = "test@example.com";

        Orders order = new Orders(orderId, userEmail);

        assertEquals(orderId, order.getOrderId());
    }

    @Test
    public void testSetOrderId() {
        String orderId = "123";
        String newOrderId = "456";
        String userEmail = "test@example.com";

        Orders order = new Orders(orderId, userEmail);

        order.setOrderId(newOrderId);

        assertEquals(newOrderId, order.getOrderId());
    }

    @Test
    public void testGetUserEmail() {
        String orderId = "123";
        String userEmail = "test@example.com";

        Orders order = new Orders(orderId, userEmail);

        assertEquals(userEmail, order.getUserEmail());
    }

    @Test
    public void testSetUserEmail() {
        String orderId = "123";
        String userEmail = "test@example.com";
        String newUserEmail = "newtest@example.com";

        Orders order = new Orders(orderId, userEmail);

        order.setUserEmail(newUserEmail);

        assertEquals(newUserEmail, order.getUserEmail());
    }
}
