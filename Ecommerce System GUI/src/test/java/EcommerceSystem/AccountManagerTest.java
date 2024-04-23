package EcommerceSystem;

import javafx.util.Pair;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountManagerTest {
    private String randomUsername, randomPassword;
    private final HashSet<Pair<String, String>> testAccounts = new HashSet<>();
    private final HashSet<String> testUsernames = new HashSet<>();
    private static Account account, managerAccount;

    @BeforeEach
    void setUp() {
        byte[] array = new byte[8];
        Random random = new Random();
        random.nextBytes(array);
        randomUsername = new String(array, StandardCharsets.UTF_8);
        random.nextBytes(array);
        randomPassword = new String(array, StandardCharsets.UTF_8);
    }

    @RepeatedTest(3)
    @Order(1)
    @DisplayName("Create random customer accounts test")
    void createCustomerAccount() throws Exception {
        assumeFalse(testUsernames.contains(randomUsername));

        HashSet<Account> accounts = AccountManager.getAccounts();
        int count = accounts.size();
        AccountManager.createAccount(randomUsername, randomPassword, "customer");
        account = AccountManager.getLoggedInUser();
        testAccounts.add(new Pair<>(randomUsername, randomPassword));
        testUsernames.add(randomUsername);

        assertEquals(count + 1, accounts.size());
        assertEquals(randomUsername, account.getUsername());
        assertEquals(randomPassword, account.getPassword());
    }

    @RepeatedTest(3)
    @Order(1)
    @DisplayName("Create random manager accounts test")
    void createManagerAccount() throws Exception {
        assumeFalse(testUsernames.contains(randomUsername));

        HashSet<Account> accounts = AccountManager.getAccounts();
        int count = accounts.size();
        AccountManager.createAccount(randomUsername, randomPassword, "manager");
        managerAccount = AccountManager.getLoggedInUser();
        testAccounts.add(new Pair<>(randomUsername, randomPassword));
        testUsernames.add(randomUsername);

        assertEquals(count + 1, accounts.size());
        assertEquals(randomUsername, managerAccount.getUsername());
        assertEquals(randomPassword, managerAccount.getPassword());
    }

    @Test
    @Order(1)
    @DisplayName("Create two accounts with the same username")
    void repeatedUsername() throws Exception {
        assumeFalse(testUsernames.contains(randomUsername));
        AccountManager.createAccount(randomUsername, randomPassword, "customer");
        testAccounts.add(new Pair<>(randomUsername, randomPassword));
        assertThrows(Exception.class, () -> AccountManager.createAccount(randomUsername, "password", "customer"));
    }

    @Test
    @Order(2)
    @DisplayName("Test valid authentication")
    void validAuthentication() {
        Iterator<Pair<String, String>> accountsIterator = testAccounts.iterator();
        Pair<String, String> account;
        while (accountsIterator.hasNext()) {
            account = accountsIterator.next();
            assertTrue(AccountManager.authenticate(account.getKey(), account.getValue()));
            assertEquals(account.getKey(), AccountManager.getLoggedInUser().getUsername());
            assertEquals(account.getValue(), AccountManager.getLoggedInUser().getPassword());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test invalid authentication")
    void invalidAuthentication() {
        Iterator<Pair<String, String>> accountsIterator = testAccounts.iterator();
        Pair<String, String> account;
        while (accountsIterator.hasNext()) {
            account = accountsIterator.next();
            assertFalse(AccountManager.authenticate(randomUsername, randomPassword));
            assertFalse(AccountManager.authenticate(randomUsername, account.getValue()));
            assertFalse(AccountManager.authenticate(account.getKey(), randomPassword));
        }
    }

    @Test
    @Order(3)
    void isManager() {
        assertTrue(AccountManager.isManager(managerAccount.getUsername()));
        assertFalse(AccountManager.isManager(account.getUsername()));
    }
}