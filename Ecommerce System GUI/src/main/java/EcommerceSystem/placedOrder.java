package EcommerceSystem;

import java.util.HashMap;
import java.util.Map;

public class placedOrder {
    private final int orderId;
    private static int orderNum=0;
    private final Map<Product, Integer> items = new HashMap<>();

    public void setItems(Map<Product, Integer> items) {
        this.items.putAll(items);
    }

    public placedOrder() {
      this.orderId=++orderNum;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}