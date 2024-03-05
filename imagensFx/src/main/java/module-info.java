module fxtestes.imagensfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.imagensfx to javafx.fxml;
    exports fxtestes.imagensfx;
}