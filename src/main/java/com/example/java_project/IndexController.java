package com.example.java_project;
import com.example.java_project.dao.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class IndexController {

    @FXML
    private Pane indexpane;

    @FXML
    private MenuItem studentId;

    @FXML
    private MenuItem teacherId;

    @FXML
    private Text textlogin;
    private User user;

    @FXML
    void courseClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/java_project/course_table.fxml" ));
        Node node = loader.load();
        indexpane.getChildren().clear();
        indexpane.getChildren().add(node);
    }

    @FXML
    void projectClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/java_project/project_table.fxml" ));
        Node node = loader.load();
        indexpane.getChildren().clear();
        indexpane.getChildren().add(node);
    }

    @FXML
    void teacherClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/java_project/instructor_table.fxml"));
        Node node = loader.load();
        indexpane.getChildren().clear();
        indexpane.getChildren().add(node);
    }

    @FXML
    void studentClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/java_project/student_table.fxml" ));
        Node node = loader.load();
        indexpane.getChildren().clear();
        indexpane.getChildren().add(node);
    }
    public void initialize(User user){
        this.user =user;
        textlogin.setText("Login : "+user.getName()+" "+ user.getLast_name());

    }
    @FXML
    void log_out(ActionEvent event) throws IOException {
//        Stage stage = (Stage) logout.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("index.fxml"));
//        stage.setScene(new Scene(fxmlLoader.load()));
//        IndexController indexController = fxmlLoader.getController();
//
//    }
}}
