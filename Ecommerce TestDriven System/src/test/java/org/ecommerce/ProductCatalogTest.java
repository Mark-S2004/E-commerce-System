package org.ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {

    private ProductCatalog catalog;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        catalog = new ProductCatalog();
        product1 = new Product("TestProduct1", "pepsi",2);
        product2 = new Product("TestProduct2", "chips",5);
        product3 = new Product("AnotherProduct", "juice",3);
        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);
    }

    @Test
    void addProduct() {
        Product newProduct = new Product("NewProduct", "rice",7);
        catalog.addProduct(newProduct);
        assertTrue(catalog.getAllProducts().contains(newProduct));
    }

    @Test
    void removeProduct() {
        catalog.removeProduct(product1);
        assertFalse(catalog.getAllProducts().contains(product1));
    }

    @Test
    void getAllProducts() {
        List<Product> allProducts = catalog.getAllProducts();
        assertEquals(3, allProducts.size());
        assertTrue(allProducts.contains(product1));
        assertTrue(allProducts.contains(product2));
        assertTrue(allProducts.contains(product3));
    }

    @Test
    void searchProducts() {
        List<Product> searchResults = catalog.searchProducts("test");
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.contains(product1));
        assertTrue(searchResults.contains(product2));

        searchResults = catalog.searchProducts("another");
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(product3));

        searchResults = catalog.searchProducts("nonexistent");
        assertEquals(0, searchResults.size());
    }
}
