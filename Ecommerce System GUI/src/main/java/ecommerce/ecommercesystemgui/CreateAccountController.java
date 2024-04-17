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
    private AccountManager a = new AccountManager();

    public void setA(AccountManager a) {
        this.a = a;
    }

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button createAccountButton;

    public void init(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void switchToLoginScene(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        a.createAccount(username,password);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        root = loader.load();
        LoginController loginController = loader.getController();
        loginController.setA(a);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}