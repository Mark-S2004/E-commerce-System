package EcommerceSystem;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Cloneable{
    private final Map<Product, Integer> items = new HashMap<>();
    private double total;

    public ShoppingCart() {}

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double getTotal() {
        return total;
    }

    public void addItem(Product item, Integer quantity) {
        total += item.getPrice() * quantity;
        items.put(item, quantity);
    }

    public void removeItem(Product item) {
        total -= item.getPrice();
        items.remove(item);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        total = 0;
    }
}