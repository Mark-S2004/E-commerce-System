package EcommerceSystem;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Cloneable {
    private Map<Product, Integer> items = new HashMap<>();
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
        if (!items.containsKey(item)) {
            total += item.getPrice() * quantity;
            items.put(item, quantity);
        } else {
            total += item.getPrice() * (quantity - items.get(item));
            items.put(item,quantity);
        }
    }

    public void removeItem(Product item) {
        if (items.containsKey(item)) {
            total -= item.getPrice() * items.get(item);
            items.remove(item);
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
        calculateTotal();
    }

    public void clear() {
        items.clear();
        total = 0;
    }

    private void calculateTotal() {
        total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product item = entry.getKey();
            Integer quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
    }
}