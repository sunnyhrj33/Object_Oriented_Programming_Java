module com.example.order {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.order to javafx.fxml;
    exports com.example.order;
}