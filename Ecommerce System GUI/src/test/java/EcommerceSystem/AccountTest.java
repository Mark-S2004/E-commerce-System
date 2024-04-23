package EcommerceSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.awt.image.AffineTransformOp;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account customer;
    private Account manager;

    @BeforeEach
    void setUp() {
        customer = new CustomerAccount("john", "password123");
        manager = new ManagerAccount("mezzo", "Ezio200");
    }

    @Test
    void getUsername() {
        assertEquals("john", customer.getUsername());
        assertEquals("mezzo", manager.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("password123", customer.getPassword());
        assertEquals("Ezio200", manager.getPassword());
    }

    @Test
    void validLogin() {
        assertTrue(customer.login("john", "password123"));
        assertTrue(manager.login("mezzo", "Ezio200"));
    }

    @RepeatedTest(10)
    void invalidLogin() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        String randomUsername = new String(array, StandardCharsets.UTF_8);
        new Random().nextBytes(array);
        String randomPassword = new String(array, StandardCharsets.UTF_8);
        assertFalse(customer.login("john", randomPassword));
        assertFalse(customer.login(randomUsername, "password123"));
        assertFalse(customer.login(randomUsername, randomPassword));
        assertFalse(manager.login("mezzo", randomPassword));
        assertFalse(manager.login(randomUsername, "Ezio200"));
        assertFalse(manager.login(randomUsername, randomPassword));
    }

    @Test
    void isManager() {
        assertTrue(manager.isManager());
        assertFalse(customer.isManager());
    }
}