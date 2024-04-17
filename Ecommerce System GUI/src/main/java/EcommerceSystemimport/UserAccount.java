package EcommerceSystemimport;
public class UserAccount {
    private String username;
    private String password;
    private boolean loggedIn;
    private AccountManager accountManager;

    public UserAccount(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.loggedIn = false;
    }

    public boolean login(String username, String password) {
        if (accountManager.authenticate(username, password)) {
            this.username = username;
            this.password = password;
            loggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}