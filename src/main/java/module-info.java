module com.example.masodfoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.masodfoku to javafx.fxml;
    exports com.example.masodfoku;
}