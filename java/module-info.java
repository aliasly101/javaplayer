module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop; // Required for javax.sound.sampled, javax.swing, and related classes

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
}