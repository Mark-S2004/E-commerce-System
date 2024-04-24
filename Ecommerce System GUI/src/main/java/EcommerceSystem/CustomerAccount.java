package EcommerceSystem;

public class CustomerAccount extends Account {
    public ShoppingCart shoppingCart = new ShoppingCart();
    public OrderManagement orderManagement=new OrderManagement();
    public CustomerAccount(String username, String password) {
        super(username, password);
    }
}
