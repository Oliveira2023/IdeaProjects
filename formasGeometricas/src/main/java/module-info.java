module fxtestes.formasgeometricas {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.formasgeometricas to javafx.fxml;
    exports fxtestes.formasgeometricas;
}