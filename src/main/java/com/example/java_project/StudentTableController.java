package com.example.java_project;
import com.example.java_project.dao.Student;
import com.example.java_project.service.ProjectService;
import com.example.java_project.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentTableController {
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> Name;

    @FXML
    private TableColumn<Student, String> Project;

    @FXML
    private TableColumn<Student, String> cin;

    @FXML
    private TableColumn<Student, LocalDate> date_naissance;

    @FXML
    private TableColumn<Student, String> email;

    @FXML
    private TableColumn<Student, String> firstName;
    @FXML
    public void initialize() throws SQLException {
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        date_naissance.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Project.setCellFactory(studentStringTableColumn -> {
            return new TableCell<>(){
                @Override
                protected void updateItem(String s, boolean b) {
                    super.updateItem(s, b);
                    if (b){
                        setGraphic(null);
                        return;
                    }
                    HBox hBox = new HBox();
                    Button button = new Button("show");
                    button.setOnAction(actionEvent -> {});
                    hBox.getChildren().add(button);
                    setGraphic(hBox);
                }
            };

        });

        tableView.getItems().addAll(StudentService.getAllStudent());



    }
}
