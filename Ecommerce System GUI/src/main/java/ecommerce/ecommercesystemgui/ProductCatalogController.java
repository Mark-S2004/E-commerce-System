package ecommerce.ecommercesystemgui;

import EcommerceSystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductCatalogController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Product> catalogList;
    @FXML
    private TextField idField, nameField, priceField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        catalogList.getItems().addAll(ProductCatalog.getAllProducts());
        System.out.println("added all items");
        catalogList.cellFactoryProperty().set(param -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty || product == null)setText(null);
                else setText(product.getName() + " - $" + product.getPrice());
            }
        });
    }

    @FXML
    private void addProduct(ActionEvent e) throws IOException {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        String id = idField.getText();
        Product product = new Product(id, name, price);

        ProductCatalog.addProduct(product);
        catalogList.getItems().add(product);
        catalogList.cellFactoryProperty().set(param -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty || product == null) setText(null);
                else setText(product.getName() + " - $" + product.getPrice());
            }
        });

        System.out.println("Product added successfully");
    }

    @FXML
    public void finish(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
