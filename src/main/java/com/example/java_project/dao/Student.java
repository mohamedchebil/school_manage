package com.example.java_project.dao;

import java.time.LocalDate;
import java.util.ArrayList;
public class Student extends User {


    private ArrayList<Project> projects;

    public Student(String name, String last_name, String email, LocalDate date_naissance, String cin) {
        super(name, last_name, email, date_naissance, cin);

    }

    public Student() {

    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
