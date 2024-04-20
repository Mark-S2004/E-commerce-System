package ecommerce.ecommercesystemgui;

import EcommerceSystemimport.AccountManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //private AccountManager a = new AccountManager();

    //public void setA(AccountManager a) {
    //    this.a = a;
   // }

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userTypeField;

    @FXML
    private Button createAccountButton;



    @FXML
    void createAccount(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = userTypeField.getText();
        AccountManager.createAccount(username, password, userType);

        FXMLLoader loader2;
        if (userType.equalsIgnoreCase("manager")) {
            loader2 = new FXMLLoader(getClass().getResource("productcatalog.fxml"));
        } else if (userType.equalsIgnoreCase("customer")) {
            loader2 = new FXMLLoader(getClass().getResource("productpage.fxml"));


        } else {
            System.out.println("Invalid user type. Redirecting to default page.");
            loader2 = new FXMLLoader(getClass().getResource("hello-view.fxml"));



        }


    //    if (userType.equalsIgnoreCase("manager")) {
     //       ProductCatalogController productCatalogController = loader.getController();
            // Set necessary properties or methods in the ProductCatalogController
      //  } else if (userType.equalsIgnoreCase("customer")) {
          //  ProductsPageController productsPageController = loader.getController();
            // Set necessary properties or methods in the ProductsPageController
      //  }
        Parent root2 = loader2.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }
}