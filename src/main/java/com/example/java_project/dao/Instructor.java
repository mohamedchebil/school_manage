package com.example.java_project.dao;

import java.time.LocalDate;
import java.util.ArrayList;

public class Instructor extends User {


    public Instructor(String name, String last_name, String email,  LocalDate date_naissance, String cin) {
        super(name, last_name, email, date_naissance, cin);
    }

    public Instructor() {

    }
}
