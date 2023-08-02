package com.example.java_project.service;

import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.Instructor;
import com.example.java_project.dao.Student;
import com.example.java_project.dao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sign_inService {
    public static User getUser(String userEmail, String userPassword) {
        Connection conn = DbConnection.getInstance().getConn();
        User user = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            stmt.setString(1, userEmail);
            stmt.setString(2, userPassword);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                if (rs.getString("type").equalsIgnoreCase("student")){
                    user = new Student();
                }
                else {
                    user = new Instructor();
                }
                user.setCin(rs.getString("CIN"));
                user.setName(rs.getString("nom"));
                user.setLast_name(rs.getString("prenom"));
                user.setDate_naissance(rs.getDate("date_naissance").toLocalDate());
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("can't connect to your account");


        }
        return user;
    }
}
