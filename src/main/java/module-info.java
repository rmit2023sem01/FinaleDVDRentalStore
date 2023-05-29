module com.example.finale {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finale to javafx.fxml;
    exports com.example.finale;
}