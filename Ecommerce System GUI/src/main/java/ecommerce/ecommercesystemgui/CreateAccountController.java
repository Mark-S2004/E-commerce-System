package ecommerce.ecommercesystemgui;

import EcommerceSystem.AccountManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

public class CreateAccountController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private RadioButton customerRadio, managerRadio;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType;

        if (customerRadio.isSelected()) userType = "customer";
        else userType = "manager";
        AccountManager.createAccount(username, password, userType);

        FXMLLoader loader;
        if (userType.equalsIgnoreCase("manager")) {
            loader = new FXMLLoader(getClass().getResource("productcatalog.fxml"));
        } else {
            loader = new FXMLLoader(getClass().getResource("catalog-view.fxml"));
        }
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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