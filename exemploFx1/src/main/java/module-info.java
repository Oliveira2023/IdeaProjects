module com.example.exemplofx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exemplofx1 to javafx.fxml;
    exports com.example.exemplofx1;
}