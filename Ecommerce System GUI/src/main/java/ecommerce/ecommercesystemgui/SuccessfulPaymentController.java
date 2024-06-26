package ecommerce.ecommercesystemgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SuccessfulPaymentController {
    @FXML
    void switchToCatalog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("catalog.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToOrders(ActionEvent event) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("order.fxml"));
         Parent root = loader.load();
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
            stage.setScene(scene);


    }
}
