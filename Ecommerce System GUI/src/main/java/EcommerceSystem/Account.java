package EcommerceSystem;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        if (AccountManager.authenticate(username, password)) {
            this.username = username;
            this.password = password;
            return true;
        }
        return false;
    }

    public boolean isManager() {
        return AccountManager.isManager(username);
    }
}
