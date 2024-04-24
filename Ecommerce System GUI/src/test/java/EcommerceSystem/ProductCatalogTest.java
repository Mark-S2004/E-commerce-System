package EcommerceSystem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductCatalogTest {
    private static final Product product1 = new Product("001", "TestProduct1",2);
    private static final Product product2 = new Product("002", "TestProduct2",5);
    private static final Product product3 = new Product("003", "AnotherProduct",3);
    private static int count = 1;

    static Stream<Product> addProduct() {
        return Stream.of(product1, product2);
    }
    @ParameterizedTest
    @MethodSource
    @Order(2)
    @DisplayName("Add different product")
    void addProduct(Product product) {
        ProductCatalog.addProduct(product);
        List<Product> products = ProductCatalog.getAllProducts();
        assertTrue(products.contains(product));
        assertEquals(count++, products.size());
    }

    @RepeatedTest(3)
    @Order(2)
    public void addSameItem() {
        ProductCatalog.addProduct(product3);
        List<Product> products = ProductCatalog.getAllProducts();

        assertEquals(count, products.size());
        assertTrue(products.contains(product3));
    }

    static Stream<Product> removeProduct() {
        return Stream.of(product1, product2);
    }
    @ParameterizedTest
    @MethodSource
    @Order(3)
    @DisplayName("Remove different products")
    void removeProduct(Product product) {
        ProductCatalog.removeProduct(product);
        List<Product> products = ProductCatalog.getAllProducts();
        assertFalse(ProductCatalog.getAllProducts().contains(product));
        assertEquals(--count, products.size());
    }

    @RepeatedTest(3)
    @Order(3)
    public void removeSameItem() {
        ProductCatalog.removeProduct(product3);
        List<Product> products = ProductCatalog.getAllProducts();

        assertEquals(count - 1, products.size());
        assertTrue(products.contains(product3));
    }

    @Test
    @Order(1)
    void getAllProducts() {
        List<Product> allProducts = ProductCatalog.getAllProducts();
        assertEquals(0, allProducts.size());
        assertFalse(allProducts.contains(product1));
        assertFalse(allProducts.contains(product2));
        assertFalse(allProducts.contains(product3));
    }

    @Test
    @Order(4)
    @DisplayName("Search products in ProductCatalog")
    void searchProducts() {
        Product[] expectedSearchResults, actualSearchResults;
        List<Product> actualArray;

        expectedSearchResults = new Product[]{product1};
        actualArray = ProductCatalog.searchProducts("TestProduct1");
        actualSearchResults = actualArray.toArray(new Product[actualArray.size()]);
        assertArrayEquals(expectedSearchResults, actualSearchResults, "Incorrect search result for Keyword: TestProduct1");

        expectedSearchResults = new Product[]{product1, product2};
        actualArray = ProductCatalog.searchProducts("TestProduct");
        actualSearchResults = actualArray.toArray(new Product[actualArray.size()]);
        assertArrayEquals(expectedSearchResults, actualSearchResults, "Incorrect search result for Keyword: TestProduct");

        expectedSearchResults = new Product[]{product1, product2, product3};
        actualArray = ProductCatalog.searchProducts("Product");
        actualSearchResults = actualArray.toArray(new Product[actualArray.size()]);
        assertArrayEquals(expectedSearchResults, actualSearchResults, "Incorrect search result for Keyword: Product");
    }
}
