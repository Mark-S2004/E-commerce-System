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
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Button loginButton;

    @FXML
    private void login(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
        AccountManager a = new AccountManager();
        UserAccount u = new UserAccount(a);

        if (u.login(username, password)) {
            FXMLLoader loader;
            if (u.isManager()) {
                 loader = new FXMLLoader(getClass().getResource("productcatalog.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("productpage.fxml"));
            }
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        } else {
            System.out.println("Wrong credentials. Please try again.");
        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}