package org.ecommerce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddItem() {
        Product item = new Product("P001", "iPhone", 999.99);
        shoppingCart.addItem(item);
        List<Product> items = shoppingCart.getItems();
        assertEquals(1, items.size());
        assertTrue(items.contains(item));
    }

    @Test
    public void testRemoveItem() {
        Product item = new Product("P001", "iPhone", 999.99);
        shoppingCart.addItem(item);
        shoppingCart.removeItem(item);
        List<Product> items = shoppingCart.getItems();
        assertEquals(0, items.size());
        assertFalse(items.contains(item));
    }

    @Test
    public void testCalculateTotal() {
        Product item1 = new Product("P001", "iPhone", 999.99);
        Product item2 = new Product("P002", "Samsung Galaxy", 799.99);
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        double total = shoppingCart.calculateTotal();
        assertEquals(1799.98, total, 0.01);
    }
}