package com.example.java_project;

import com.example.java_project.dao.Instructor;
import com.example.java_project.service.CourseService;
import com.example.java_project.service.InstructorService;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class InstructorTableController {
    @FXML
    private TableView<Instructor> tableView;
    @FXML
    private TableColumn<Instructor, String> cin;

    @FXML
    private TableColumn<Instructor, LocalDate> date_naissance;

    @FXML
    private TableColumn<Instructor, String> email;

    @FXML
    private TableColumn<Instructor, String> firstname;

    @FXML
    private TableColumn<Instructor, String> lastNAme;
    @FXML
    public void initialize() throws SQLException {
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNAme.setCellValueFactory(instructorStringCellDataFeatures -> new ReadOnlyStringWrapper( instructorStringCellDataFeatures.getValue().getLast_name()));
        date_naissance.setCellValueFactory(instructorLocalDateCellDataFeatures -> new ReadOnlyObjectWrapper<>(instructorLocalDateCellDataFeatures.getValue().getDate_naissance()));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getItems().addAll(InstructorService.getAllInstructors());

    }
}
