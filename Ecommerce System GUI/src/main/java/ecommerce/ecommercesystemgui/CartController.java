package ecommerce.ecommercesystemgui;

import EcommerceSystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ShoppingCart shoppingCart;
    @FXML
    private ListView<Map.Entry<Product, Integer>> cartList;
    @FXML
    private Label totalLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shoppingCart = ((CustomerAccount) AccountManager.getLoggedInUser()).shoppingCart;
        cartList.getItems().addAll(new ArrayList<>(shoppingCart.getItems().entrySet()));
        cartList.cellFactoryProperty().set(param -> new ListCell<>() {
            @Override
            protected void updateItem(Map.Entry<Product, Integer> cartItem, boolean empty) {
                super.updateItem(cartItem, empty);
                if (empty || cartItem == null) {
                    setText(null);
                } else {
                    setText(cartItem.getKey().getName() + " - #" + cartItem.getValue());
                }
            }
        });

        totalLabel.setText(((Double) shoppingCart.getTotal()).toString());
    }

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void switchToPayment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payment.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void switchToCatalog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("catalog-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void removeItem() {
        Map.Entry<Product, Integer> selectedProduct = cartList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            shoppingCart.removeItem(selectedProduct.getKey());
            cartList.getItems().remove(selectedProduct);
            totalLabel.setText(((Double) shoppingCart.getTotal()).toString());
        }
        cartList.cellFactoryProperty().set(param -> new ListCell<>() {
            @Override
            protected void updateItem(Map.Entry<Product, Integer> cartItem, boolean empty) {
                super.updateItem(cartItem, empty);
                if (empty || cartItem == null) {
                    setText(null);
                } else {
                    setText(cartItem.getKey().getName() + " - #" + cartItem.getValue());
                }
            }
        });
    }
}
