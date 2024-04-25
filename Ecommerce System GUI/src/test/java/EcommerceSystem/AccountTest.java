package EcommerceSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}