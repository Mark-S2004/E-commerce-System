package org.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {
    private UserAccount userAccount;

    @BeforeEach
    public void setUp() {
        userAccount = new UserAccount("john", "password123");
    }

    @Test
    public void testLoginWithValidCredentials() {
        assertTrue(userAccount.login("john", "password123"));
        assertTrue(userAccount.isLoggedIn());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        assertFalse(userAccount.login("john", "wrongpassword"));
        assertFalse(userAccount.isLoggedIn());
    }

    @Test
    public void testLogout() {
        userAccount.login("john", "password123");
        userAccount.logout();
        assertFalse(userAccount.isLoggedIn());
    }
}