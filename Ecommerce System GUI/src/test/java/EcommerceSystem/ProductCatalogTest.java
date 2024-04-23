package EcommerceSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        product1 = new Product("TestProduct1", "pepsi",2);
        product2 = new Product("TestProduct2", "chips",5);
        product3 = new Product("AnotherProduct", "juice",3);
        ProductCatalog.addProduct(product1);
        ProductCatalog.addProduct(product2);
        ProductCatalog.addProduct(product3);
    }

    @Test
    void addProduct() {
        Product newProduct = new Product("NewProduct", "rice",7);
        ProductCatalog.addProduct(newProduct);
        assertTrue(ProductCatalog.getAllProducts().contains(newProduct));
    }

    @Test
    void removeProduct() {
        ProductCatalog.removeProduct(product1);
        assertFalse(ProductCatalog.getAllProducts().contains(product1));
    }

    @Test
    void getAllProducts() {
        List<Product> allProducts = ProductCatalog.getAllProducts();
        assertEquals(3, allProducts.size());
        assertTrue(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
        assertTrue(allProducts.contains(product3));
    }

    @Test
    void searchProducts() {
    }
}
