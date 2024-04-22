package EcommerceSystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private static List<Product> products=new ArrayList<>();

    public ProductCatalog() {}

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static void removeProduct(Product product) {
        products.remove(product);
    }

    public static List<Product> getAllProducts() {
        return products;
    }

    public List<Product> searchProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getId().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }
}