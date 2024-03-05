module fxtestes.appmovrobo {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.appmovrobo to javafx.fxml;
    exports fxtestes.appmovrobo;
}