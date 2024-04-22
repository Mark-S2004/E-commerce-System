package EcommerceSystem;

public class CustomerAccount extends Account {
    public ShoppingCart shoppingCart = new ShoppingCart();
    public CustomerAccount(String username, String password) {
        super(username, password);
    }
}
