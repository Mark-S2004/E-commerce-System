package ecommerce.ecommercesystemgui;
import EcommerceSystem.AccountManager;
import EcommerceSystem.CustomerAccount;
import EcommerceSystem.PaymentProcessor;
import EcommerceSystem.ShoppingCart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class paymentController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    ShoppingCart shoppingCart;
    @FXML
    private TextField balanceField;
    @FXML
    private Label totalLabel;
    @FXML
    private Label errorLabel;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shoppingCart = ((CustomerAccount) AccountManager.getLoggedInUser()).shoppingCart;
        totalLabel.setText(((Double) shoppingCart.getTotal()).toString());
    }

    @FXML
     void pay(ActionEvent event) throws IOException{
        String enteredAmount=balanceField.getText();
        PaymentProcessor p=new PaymentProcessor();
        p.connectPaymentGateway();
       //if (p.processPayment(Double.parseDouble(enteredAmount))){
        //   shoppingCart.clear();
        if(p.processPayment(Double.parseDouble(enteredAmount))&&Double.parseDouble(enteredAmount)>=Double.parseDouble(totalLabel.getText())){
               shoppingCart.clear();
           root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lastwindow.fxml")));
           stage = (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }
       else {//System.out.println("error during payment");
                 errorLabel.setVisible(true); }
    }

    @FXML
    void switchToCart(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cart.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
