module fxtestes.mostraimgens2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.mostraimgens2 to javafx.fxml;
    exports fxtestes.mostraimgens2;
}