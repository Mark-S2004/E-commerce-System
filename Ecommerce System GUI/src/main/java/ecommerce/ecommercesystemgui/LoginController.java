package ecommerce.ecommercesystemgui;

import EcommerceSystemimport.AccountManager;
import EcommerceSystemimport.UserAccount;
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

public class LoginController {
private AccountManager a;
    private Stage stage;

    public void setA(AccountManager a) {
        this.a = a;
    }

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    public void init(Stage stage) {
        this.stage = stage;
    }


    @FXML
    private void goToCreateAccount(ActionEvent event) throws Exception {

        String username = usernameField.getText();
        String password = passwordField.getText();

        UserAccount u=new UserAccount(a);
        if(u.login(username,password)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Createaccount.fxml"));
            Parent root = loader.load();
            CreateAccountController createAccountController = loader.getController();
            createAccountController.setA(a);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
        else { System.out.println("Wrong Credentials");}

    }
}