package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

public class PlacedOrderTest {
    private placedOrder order;

    @BeforeEach
    void setUp() {
        order = new placedOrder();
    }

    @Test
    @Order(3)
    void setItems() {
        Map<Product, Integer> items = new HashMap<>();
        items.put(new Product("P001", "Pepsi", 5), 2);
        items.put(new Product("P002", "Coca", 4), 1);
        order.setItems(items);

        assertEquals(items, order.getItems());
    }

    @RepeatedTest(3)
    @Order(1)
    void getOrderId(RepetitionInfo repetitionInfo) {
        assertEquals(repetitionInfo.getCurrentRepetition(), order.getOrderId());
    }

    @Test
    @Order(2)
    void getItems() {
        assertEquals(0, order.getItems().size());
    }
}
