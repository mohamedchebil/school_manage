module com.example.java_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;


    opens com.example.java_project to javafx.fxml;
    opens com.example.java_project.dao to javafx.base;
    exports com.example.java_project;
}