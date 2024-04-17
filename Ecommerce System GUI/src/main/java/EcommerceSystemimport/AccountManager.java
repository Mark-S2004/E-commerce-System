package EcommerceSystemimport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    private List<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String username, String password) {
        Account newAccount = new Account(username, password);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    public void displayAccounts() {
        System.out.println("Accounts:");
        for (Account account : accounts) {
            System.out.println("Username: " + account.getUsername() + ", Password: " + account.getPassword());
        }
    }
    public boolean authenticate(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}