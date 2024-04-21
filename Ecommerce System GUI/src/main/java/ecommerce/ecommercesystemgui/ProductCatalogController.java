package ecommerce.ecommercesystemgui;

import EcommerceSystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class ProductCatalogController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<Product> productList;

    @FXML
    private TextField Idfield;

    @FXML
    private TextField Namefield;

    @FXML
    private TextField Pricefield;

    private ProductCatalog pc=new ProductCatalog();
   // private ProductPageController productPageController;

    // public void initialize(ProductList productlist) {
   //     this.productlist = productlist;
   // }
//public void setProductCatalog(ProductCatalog pc){
//    this.pc=pc;
//}
    @FXML
    private void addProduct(ActionEvent e) throws IOException {

        String name = Namefield.getText();
        double price = Double.parseDouble(Pricefield.getText());
        String id = Idfield.getText();
        Product product = new Product(id, name, price);
        pc.addProduct(product);
        productList.getItems().add(product);


        productList.cellFactoryProperty().set(param -> new ListCell<Product>() {
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
    // Implement other methods as needed
}
