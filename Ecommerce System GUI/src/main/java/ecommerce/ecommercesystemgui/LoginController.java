package ecommerce.ecommercesystemgui;

import EcommerceSystem.Account;
import EcommerceSystem.AccountManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label errorLabel;

    @FXML
    private void login(ActionEvent event) throws IOException{
        String username = usernameField.getText();
        String password = passwordField.getText();
        Account u = new Account(username, password);

        if (AccountManager.authenticate(username, password)) {
            FXMLLoader loader;
            if (AccountManager.isManager(u.getUsername())) {
                 loader = new FXMLLoader(getClass().getResource("addProducts.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("catalog.fxml"));
            }
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
        } else {
            errorLabel.setVisible(true);
        }
    }

    @FXML
    void cancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}