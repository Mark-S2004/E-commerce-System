package EcommerceSystem;


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
            this.loggedIn = true;
            return true;
        }
        return false;
    }

    public void logout() {
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isManager() {
        if (isLoggedIn()) {
            return accountManager.isManager(username);
        }
        return false;
    }

}