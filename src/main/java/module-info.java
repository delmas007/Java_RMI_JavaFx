module com.example.gneugneu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;


    opens com.example.gneugneu to javafx.fxml;
    exports com.example.gneugneu;
    exports Server;
    opens Server to javafx.fxml;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Tchat;
    opens Tchat to javafx.fxml;
}