package com.example.java_project;
import com.example.java_project.dao.Project;
import com.example.java_project.service.InstructorService;
import com.example.java_project.service.ProjectService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectTableController {
    @FXML
    private TableView<Project> tableView;
    @FXML
    private TableColumn<Project, String> description;

    @FXML
    private TableColumn<Project, Boolean> evaluated;

    @FXML
    private TableColumn<Project, String> name;

    @FXML
    private TableColumn<Project, Boolean> submitted;

    @FXML
    public void initialize() throws SQLException {

        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        submitted.setCellValueFactory(new PropertyValueFactory<>("submitted"));
        evaluated.setCellValueFactory(new  PropertyValueFactory<>("evaluated"));
        tableView.getItems().addAll(ProjectService.getAllProjects());

    }
}
