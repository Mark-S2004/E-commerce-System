package ecommerce.ecommercesystemgui;

import EcommerceSystem.AccountManager;
import EcommerceSystem.UserAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    private Stage stage;


    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;



    @FXML
    private void login(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
        AccountManager a = new AccountManager();
        UserAccount u = new UserAccount(a);
        if (u.login(username, password)) {
            FXMLLoader loader2;
            if (u.isManager()) {
                 loader2 = new FXMLLoader(getClass().getResource("productcatalog.fxml"));
                //  ProductCatalogController productCatalogController = loader.getController();
                // Set necessary properties or methods in the ProductCatalogController
            } else {
                loader2 = new FXMLLoader(getClass().getResource("productpage.fxml"));
                // ProductPageController productPageController = loader.getController();
                // Set necessary properties or methods in the ProductsPageController
            }

            Parent root = loader2.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } else {
            System.out.println("Wrong credentials. Please try again.");
        }
    }
}