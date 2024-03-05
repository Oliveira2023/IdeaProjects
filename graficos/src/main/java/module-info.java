module fxtestes.graficos {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.graficos to javafx.fxml;
    exports fxtestes.graficos;
}