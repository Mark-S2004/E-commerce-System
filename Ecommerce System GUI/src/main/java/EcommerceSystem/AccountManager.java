package EcommerceSystem;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private static List<Account> accounts = new ArrayList<>();
    private static Account loggedInUser;

    public AccountManager() {}

    public static Account getLoggedInUser() {
        return loggedInUser;
    }

    public static void createAccount(String username, String password, String type) {
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

    protected static List<Account> getAccounts() {
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