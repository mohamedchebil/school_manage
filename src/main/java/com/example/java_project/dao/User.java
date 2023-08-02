package com.example.java_project.dao;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String last_name;
    private String email;
    private String password;
    private LocalDate Date_naissance;
    private  String cin;
    private ArrayList<Course> courses;

    public User(String name, String last_name, String email,  LocalDate date_naissance, String cin) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.Date_naissance = date_naissance;
        this.cin = cin;
        this.courses = courses;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        Date_naissance = date_naissance;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
