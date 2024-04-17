module ecommerce.ecommercesystemgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ecommerce.ecommercesystemgui to javafx.fxml;
    exports ecommerce.ecommercesystemgui;
}