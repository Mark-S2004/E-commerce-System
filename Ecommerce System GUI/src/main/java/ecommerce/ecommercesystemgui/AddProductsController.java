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
import java.util.Map;
import java.util.ResourceBundle;

public class AddProductsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Boolean duplicate=false;
    @FXML
    private ListView<Product> catalogList;
    @FXML
    private TextField idField, nameField, priceField;
    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabel2;

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
        String priceText = priceField.getText();
        String id = idField.getText();
        duplicate=false;
        for(Product productloop:ProductCatalog.getAllProducts()) {
            if (name.equals(productloop.getName())) {
                duplicate = true;
                break;
            }
        }
        if (duplicate)
            errorLabel2.setVisible(true);

        else {
            try {
                double price = Double.parseDouble(priceText);
                Product product = new Product(id, name, price);
                ProductCatalog.addProduct(product);
                catalogList.getItems().add(product);
                catalogList.setCellFactory(param -> new ListCell<Product>() {
                    @Override
                    protected void updateItem(Product product, boolean empty) {
                        super.updateItem(product, empty);
                        if (empty || product == null)
                            setText(null);
                        else
                            setText(product.getName() + " - $" + product.getPrice());
                    }
                });
                nameField.clear();
                idField.clear();
                priceField.clear();
                System.out.println("Product added successfully");

            } catch (NumberFormatException ex) {
                errorLabel.setVisible(true);
            }
        }

    }

    @FXML
    void removeItem() {
        Product selectedProduct = catalogList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            ProductCatalog.removeProduct(selectedProduct);
            catalogList.getItems().remove(selectedProduct);
           // totalLabel.setText(((Double) shoppingCart.getTotal()).toString());
        }
        catalogList.cellFactoryProperty().set(param -> new ListCell<>() {
            @Override
            protected void updateItem(Product cartItem, boolean empty) {
                super.updateItem(cartItem, empty);
                if (empty || cartItem == null) {
                    setText(null);
                } else {
                    setText(cartItem.getName() + "- $" + cartItem.getPrice());
                }
            }
        });
    }
    @FXML
    public void finish(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
