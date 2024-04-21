package ecommerce.ecommercesystemgui;

import EcommerceSystem.Product;
import EcommerceSystem.ProductCatalog;
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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class catalogController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ProductCatalog productCatalog;
    @FXML
    private ListView<Product> catalogList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        catalogList.getItems().addAll(productCatalog.getAllProducts());
        System.out.println("added all items");
        catalogList.cellFactoryProperty().set(param -> new ListCell<Product>() {
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
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
