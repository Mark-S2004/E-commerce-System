package ecommerce.ecommercesystemgui;

import EcommerceSystemimport.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ProductCatalog pc;
    @FXML
    public ListView<Product> searchResultsList;

    @FXML
    private ListView<Product> cartItemList;

    @FXML
    private TextField totalField;

    private ShoppingCart shoppingCart=new ShoppingCart();
    // private ProductCatalog pc;
    //  public void setProductCatalog(ProductCatalog pc) {
    // this.pc=pc;
    // }

    @FXML
    private void updateSearchList(ActionEvent e) throws IOException {
        searchResultsList.getItems().addAll(pc.getAllProducts());
        System.out.println("added all items");
        searchResultsList.cellFactoryProperty().set(param -> new ListCell<Product>() {
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
    void addToCart(ActionEvent e) throws IOException {
        Product selectedProduct = searchResultsList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            shoppingCart.addItem(selectedProduct);
            cartItemList.getItems().add(selectedProduct);
            updateTotal();
        }
        cartItemList.cellFactoryProperty().set(param -> new ListCell<Product>() {
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
    void removeFromCart(ActionEvent e) throws IOException {
        Product selectedProduct = searchResultsList.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            shoppingCart.removeItem(selectedProduct);
            cartItemList.getItems().remove(selectedProduct);
            updateTotal();
        }
        cartItemList.cellFactoryProperty().set(param -> new ListCell<Product>() {
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

    private void updateTotal() {
        double total = shoppingCart.calculateTotal();
        totalField.setText("$" + String.format("%.2f", total));
    }

    @FXML
    public void movetopayment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("payment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
