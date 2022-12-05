module com.example.vis_projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vis_projekt to javafx.fxml;
    exports com.example.vis_projekt;
}