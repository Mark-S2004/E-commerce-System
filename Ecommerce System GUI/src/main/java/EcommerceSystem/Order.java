package EcommerceSystem;

public class Order {
    private int orderId;
    //private String userEmail;
    private static int orderNum=0;
    ShoppingCart cart;
    public Order(ShoppingCart cart) {
      this.orderId=++orderNum;
        this.cart=cart;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public static int getOrderNum() {
        return orderNum;
    }

    public static void setOrderNum(int orderNum) {
        Order.orderNum = orderNum;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}