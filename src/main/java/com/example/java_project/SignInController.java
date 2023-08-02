package com.example.java_project;
import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.User;
import com.example.java_project.service.Sign_inService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController {
    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    void cancel(ActionEvent event) {

    }



    @FXML
    void sign_in(ActionEvent event) throws IOException {
        String userEmail = email.getText();
        String userPassword = mdp.getText();

        User user = Sign_inService.getUser(userEmail, userPassword);


        if (user != null ) {

            Stage stage = (Stage) email.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("index.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            IndexController indexController = fxmlLoader.getController();
            indexController.initialize(user);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign In Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The email or password you entered is incorrect. Please try again.");
            alert.showAndWait();
        }
    }
}