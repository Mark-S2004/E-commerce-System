package ecommerce.ecommercesystemgui;

import EcommerceSystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    private ListView<Map.Entry<Product, Integer>> cartList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartList.getItems().addAll(new ArrayList<>(((CustomerAccount) AccountManager.getLoggedInUser()).shoppingCart.getItems().entrySet()));
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

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}
