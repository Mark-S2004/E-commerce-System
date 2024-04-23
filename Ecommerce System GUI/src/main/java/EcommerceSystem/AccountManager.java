package EcommerceSystem;

import java.util.HashSet;

public class AccountManager {
    private static final HashSet<Account> accounts = new HashSet<>();
    private static final HashSet<String> usernames = new HashSet<>();
    private static Account loggedInUser;

    public AccountManager() {}

    public static Account getLoggedInUser() {
        return loggedInUser;
    }

    public static void createAccount(String username, String password, String type) throws CreateAccountException {
        if (usernames.contains(username)) {
            throw new CreateAccountException();
        } else {
            usernames.add(username);
        }
        if(type.equalsIgnoreCase("manager")) {
            ManagerAccount newAccount = new ManagerAccount(username, password);
            loggedInUser = newAccount;
            accounts.add(newAccount);
        }
        else if(type.equalsIgnoreCase("customer")) {
            CustomerAccount newAccount = new CustomerAccount(username, password);
            loggedInUser = newAccount;
            accounts.add(newAccount);
        }
    }

    protected static HashSet<Account> getAccounts() {
        return accounts;
    }

    public static boolean authenticate(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                loggedInUser = account;
                return true;
            }
        }
        return false;
    }


    public static boolean isManager(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account instanceof ManagerAccount) {
                return true;
            }
        }
        return false;
    }

}