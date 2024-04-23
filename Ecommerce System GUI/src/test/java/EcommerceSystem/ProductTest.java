package EcommerceSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    static Product product;

    @BeforeAll
    static void setUp() {
        product = new Product("1", "Pepsi", 5);
    }

    @Test
    @Order(1)
     void getId() {
        assertEquals("1", product.getId());
    }

    @Test
    @Order(2)
    void setId() {
        product.setId("2");
        assertEquals("2", product.getId());
    }

    @Test
    @Order(1)
    void getName() {
        assertEquals("Pepsi", product.getName());
    }

    @Test
    @Order(2)
    void setName() {
        product.setName("Coca");
        assertEquals("Coca", product.getName());
    }

    @Test
    @Order(1)
    void getPrice() {
        assertEquals(5, product.getPrice());
    }

    @Test
    @Order(2)
    void setPrice() {
        product.setPrice(4);
        assertEquals(4, product.getPrice());
    }
}