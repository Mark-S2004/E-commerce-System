package EcommerceSystem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Order {
    private int orderId;
    //private String userEmail;
    int total;
    private static int orderNum=0;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setItems(Map<Product, Integer> items) {
        for(Map.Entry<Product,Integer> item:items.entrySet()) {
            this.items.put(item.getKey(),item.getValue());
        }
    }

    //final ShoppingCart  cart=new ShoppingCart();
   private Map<Product, Integer> items = new HashMap<>();
    public Order() {
      this.orderId=++orderNum;
        //this.cart=cart;
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

    public int getTotal() {
        return total;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}