package EcommerceSystem;

        import java.util.ArrayList;
        import java.util.List;

public class ProductCatalog {
    private static List<Product> products=new ArrayList<>();

    public ProductCatalog() {

    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public static List<Product> getAllProducts() {
        return products;
    }

   /* public List<Product> searchProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getId().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }*/
   public static int calculateLevenshteinDistance(String word1, String word2) {
       int[][] dp = new int[word1.length() + 1][word2.length() + 1];

       for (int i = 0; i <= word1.length(); i++) {
           dp[i][0] = i;
       }

       for (int j = 0; j <= word2.length(); j++) {
           dp[0][j] = j;
       }

       for (int i = 1; i <= word1.length(); i++) {
           for (int j = 1; j <= word2.length(); j++) {
               int cost = (word1.charAt(i - 1) != word2.charAt(j - 1)) ? 1 : 0;
               dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + cost));
           }
       }

       return dp[word1.length()][word2.length()];
   }

    public static List<Product> searchProducts(String keyword) {
        List<Product> searchResults = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;

        for (Product product : products) {
            String productName = product.getName();
            int distance = calculateLevenshteinDistance(keyword.toLowerCase(), productName.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                searchResults.clear();
                searchResults.add(product);
            } else if (distance == minDistance) {
                searchResults.add(product);
            }
        }

        return searchResults;
    }
}