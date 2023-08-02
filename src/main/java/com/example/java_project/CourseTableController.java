package com.example.java_project;
import com.example.java_project.dao.Course;
import com.example.java_project.service.CourseService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseTableController {
    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, Integer> id;

    @FXML
    private TableColumn<Course, String> name;
    @FXML
    public void initialize() throws SQLException {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getItems().addAll(CourseService.getAllCourses());


}

}
