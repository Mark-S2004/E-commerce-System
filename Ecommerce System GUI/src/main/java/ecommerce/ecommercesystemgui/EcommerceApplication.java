package ecommerce.ecommercesystemgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EcommerceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EcommerceApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //AccountManager a=new AccountManager();

        launch();
    }
}