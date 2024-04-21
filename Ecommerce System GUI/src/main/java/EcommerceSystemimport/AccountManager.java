package EcommerceSystemimport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    private static List<Account> accounts=new ArrayList<>();

    public AccountManager() {

    }

    public static void createAccount(String username, String password, String type) {
        //Account newAccount;
        if(type.equalsIgnoreCase("manager")){
        ManagerAccount newAccount = new ManagerAccount(username, password);
            accounts.add(newAccount);}
        else if(type.equalsIgnoreCase("customer")){
            CustomerAccount newAccount = new CustomerAccount(username, password);
            accounts.add(newAccount);}
        else{System.out.println("wronggg");}
        System.out.println("Account created successfully!");
    }

    public static void displayAccounts() {
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


    public boolean isManager(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account instanceof ManagerAccount) {
                return true;
            }
        }
        return false;
    }

}