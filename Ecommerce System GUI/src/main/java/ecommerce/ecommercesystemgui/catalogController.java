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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class catalogController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Product> catalogList;
    @FXML
    private Label quantityLabel;
    @FXML
    private Button decrementButton;
    @FXML
    private TextField searchField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        catalogList.getItems().addAll(ProductCatalog.getAllProducts());
        System.out.println("added all items");
        catalogList.cellFactoryProperty().set(param -> new ListCell<>() {
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);

                if (empty || product == null) {
                    setText(null);
                } else {
                    setText(product.getName() + " - $" + product.getPrice());
                }
            }
        });
    }

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void searchProduct(ActionEvent event) {
        String keyword = searchField.getText();
        List<Product> searchResults = ProductCatalog.searchProducts(keyword);
        catalogList.getItems().setAll(searchResults);
        quantityLabel.setText("1");
        decrementButton.setDisable(true);
    }

    @FXML
    void switchToCart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void increment() {
        quantityLabel.setText(((Integer)(Integer.parseInt(quantityLabel.getText()) + 1)).toString());
        decrementButton.setDisable(false);
    }

    @FXML
    void decrement() {
        int quantity = Integer.parseInt(quantityLabel.getText()) - 1;
        quantityLabel.setText(Integer.toString(quantity));
        if (quantity == 1) decrementButton.setDisable(true);
    }

    @FXML
    void addToCart() {
        Product selectedProduct = catalogList.getSelectionModel().getSelectedItem();
        ShoppingCart shoppingCart = ((CustomerAccount) AccountManager.getLoggedInUser()).shoppingCart;
        if (selectedProduct != null) {
            shoppingCart.addItem(selectedProduct, Integer.parseInt(quantityLabel.getText()));
        }
    }
}
