package ecommerce.ecommercesystemgui;
import EcommerceSystemimport.PaymentProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class paymentController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField balanceField;
    @FXML
    private Label total;

    public void displayName(int totall) {
        total.setText("total: " + totall);
    }
    @FXML
     void pay(ActionEvent event) throws IOException{
        String enteredAmount=balanceField.getText();
        PaymentProcessor p=new PaymentProcessor();
        p.connectPaymentGateway();
       if (p.processPayment(Double.parseDouble(enteredAmount))){
           root = FXMLLoader.load(getClass().getResource("lastwindow.fxml"));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }
       else {System.out.println("error during payment");}
    }
    @FXML
    void returnn(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
