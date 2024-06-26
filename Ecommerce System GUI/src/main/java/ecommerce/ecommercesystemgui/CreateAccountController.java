package ecommerce.ecommercesystemgui;

import EcommerceSystem.AccountManager;
import EcommerceSystem.CreateAccountException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateAccountController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private RadioButton customerRadio, managerRadio;
    @FXML
    private Label errorLabel1, errorLabel2;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType;

        if (customerRadio.isSelected()) userType = "customer";
        else userType = "manager";
        try {
            AccountManager.createAccount(username, password, userType);
        } catch (CreateAccountException e) {
            errorLabel1.setVisible(true);
            errorLabel2.setVisible(true);
            usernameField.clear();
            return;
        }

        FXMLLoader loader;
        if (userType.equalsIgnoreCase("manager")) {
            loader = new FXMLLoader(getClass().getResource("addProducts.fxml"));
        } else {
            loader = new FXMLLoader(getClass().getResource("catalog.fxml"));
        }
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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