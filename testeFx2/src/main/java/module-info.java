module fxtestes.testefx2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fxtestes.testefx2 to javafx.fxml;
    exports fxtestes.testefx2;
}