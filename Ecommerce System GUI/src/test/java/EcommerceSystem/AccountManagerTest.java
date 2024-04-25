package EcommerceSystem;

import javafx.util.Pair;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountManagerTest {
    private String randomUsername, randomPassword;
    private static final HashSet<Pair<String, String>> testAccounts = new HashSet<>();
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
    void createCustomerAccount() throws CreateAccountException {
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
    void createManagerAccount() throws CreateAccountException {
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
    void repeatedUsername() throws CreateAccountException {
        assumeFalse(testUsernames.contains(randomUsername));
        AccountManager.createAccount(randomUsername, randomPassword, "customer");
        testAccounts.add(new Pair<>(randomUsername, randomPassword));
        assertThrows(CreateAccountException.class, () -> AccountManager.createAccount(randomUsername, "password", "customer"));
    }

    static Stream<Pair<String, String>> validAuthentication() {
        return testAccounts.stream();
    }
    @ParameterizedTest
    @MethodSource
    @Order(2)
    @DisplayName("Test valid authentication")
    void validAuthentication(Pair<String, String> account) {
        assertTrue(AccountManager.authenticate(account.getKey(), account.getValue()));
        assertEquals(account.getKey(), AccountManager.getLoggedInUser().getUsername());
        assertEquals(account.getValue(), AccountManager.getLoggedInUser().getPassword());
    }

    static Stream<Pair<String, String>> invalidAuthentication() {
        return testAccounts.stream();
    }
    @ParameterizedTest
    @MethodSource
    @Order(2)
    @DisplayName("Test invalid authentication")
    void invalidAuthentication(Pair<String, String> account) {
        assertFalse(AccountManager.authenticate(randomUsername, randomPassword));
        assertFalse(AccountManager.authenticate(randomUsername, account.getValue()));
        assertFalse(AccountManager.authenticate(account.getKey(), randomPassword));
    }

    @Test
    @Order(3)
    void isManager() {
        assertTrue(AccountManager.isManager(managerAccount.getUsername()));
        assertFalse(AccountManager.isManager(account.getUsername()));
    }
}