package EcommerceSystem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingCartTest {
    private ShoppingCart shoppingCart;
    private static final ShoppingCart staticCart = new ShoppingCart();
    private final static Product item1 = new Product("P001", "iPhone", 999.99);
    private final static Product item2 = new Product("P002", "Pepsi", 9.99);

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    @Order(1)
    public void getTotal() {
        shoppingCart.addItem(item1, 5);
        shoppingCart.addItem(item2, 2);

        assertEquals(item1.getPrice() * 5 + item2.getPrice() * 2, shoppingCart.getTotal());
    }

    @RepeatedTest(3)
    @Order(2)
    public void addSameItem() {
        Random random = new Random();
        int quantity = random.nextInt(1000);
        staticCart.addItem(item1, quantity);
        Map<Product, Integer> items = staticCart.getItems();

        assertEquals(1, items.size());
        assertTrue(items.containsKey(item1));
        assertTrue(items.containsValue(quantity));
        assertFalse(items.containsValue(random.nextInt(1000)));
        assertEquals(round(item1.getPrice() * quantity), round(staticCart.getTotal()));
    }

    static Stream<Arguments> addDifferentItems() {
        return Stream.of(
                Arguments.arguments(item1, 5),
                Arguments.arguments(item2, 2)
        );
    }
    @ParameterizedTest
    @MethodSource
    @Order(3)
    public void addDifferentItems(Product item, int quantity) {
        shoppingCart.addItem(item, quantity);
        Map<Product, Integer> items = shoppingCart.getItems();

        assertEquals(1, items.size());
        assertTrue(items.containsKey(item));
        assertTrue(items.containsValue(quantity));
        assertFalse(items.containsValue(new Random().nextInt(1000) + 6));
    }

    static Stream<Arguments> removeItem() {
        return Stream.of(
                Arguments.arguments(item1, 5, item2, 2),
                Arguments.arguments(item2, 2, item1, 5)
        );
    }
    @ParameterizedTest
    @MethodSource
    @Order(4)
    public void removeItem(Product removeItem, int quantity, Product remainItem, int quantityRemain) {
        shoppingCart.addItem(removeItem, quantity);
        shoppingCart.addItem(remainItem, quantityRemain);
        double total = shoppingCart.getTotal();
        shoppingCart.removeItem(removeItem);
        shoppingCart.removeItem(removeItem);
        Map<Product, Integer> items = shoppingCart.getItems();

        assertEquals(1, items.size(), "Only one item should be in the cart");
        assertEquals(total - removeItem.getPrice() * quantity, shoppingCart.getTotal());
        assertFalse(items.containsKey(removeItem));
        assertFalse(items.containsValue(quantity));
        assertTrue(items.containsKey(remainItem));
        assertTrue(items.containsValue(quantityRemain));
    }



    @Test
    @Order(1)
    public void getItems() {
        Map<Product, Integer> items = shoppingCart.getItems();

        assertEquals(0, items.size());
    }

    @Test
    @Order(4)
    public void clear() {
        shoppingCart.addItem(item1, 5);
        shoppingCart.addItem(item2, 2);
        shoppingCart.clear();
        Map<Product, Integer> items = shoppingCart.getItems();

        assertEquals(0, items.size());
        assertFalse(items.containsKey(item1));
        assertFalse(items.containsValue(5));
        assertFalse(items.containsKey(item2));
        assertFalse(items.containsValue(2));
    }
}