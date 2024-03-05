module fxtestes.showimages {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxtestes.showimages to javafx.fxml;
    exports fxtestes.showimages;
}