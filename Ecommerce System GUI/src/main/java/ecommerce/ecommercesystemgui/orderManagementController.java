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
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class orderManagementController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    OrderManagement orderManagement;

   /* @FXML
    private ListView<Map.Entry<Product, Integer>> cartList;*/
   /* @FXML
    private Label staticLabel;*/
    @FXML
    private Pagination p;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderManagement = ((CustomerAccount) AccountManager.getLoggedInUser()).orderManagement;
        Label staticLabel = new Label();
        staticLabel.setText("Order placed");
        int numPages = orderManagement.getAllOrders().size();
        if(numPages==0) return;
        p.setPageCount(numPages);
        p.setCurrentPageIndex(0);
        p.setPageFactory(pageIndex -> {
            // Create and return the content for each page
            VBox pageContent = new VBox();
            List<placedOrder> orders = orderManagement.getAllOrders();
            System.out.println("order size"+orders.size());
            placedOrder placedOrder = orders.get(pageIndex); // Get the order for the current page
            Label orderLabel = new Label("Order ID: " + placedOrder.getOrderId() + " Items:");

            // Create a string representation of items in the cart
            StringBuilder itemsText= new StringBuilder();
            System.out.println("cart items content"+ placedOrder.getItems());
            Map<Product, Integer> cartItems = placedOrder.getItems();
            System.out.println("cartitemssize"+cartItems.size());
            for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
                itemsText.append(entry.getKey().getName()).append(" - #").append(entry.getValue()).append("\n");
            }

            Label itemsLabel = new Label(itemsText.toString());

            // Customize order label with additional information if needed
            pageContent.getChildren().addAll(orderLabel, itemsLabel, staticLabel);
            return pageContent;
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
    void switchToCatalog(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("catalog.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void switchToCart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

}

