package com.example.java_project.service;



import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.Instructor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class InstructorService {
    final static String INSTRUCTOR_TYPE = "instructor";
    static public int addInstructor(Instructor instructor) throws SQLException{
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO User(nom,prenom,date_naissance,email,password,cin,type) values(?,?,?,?,?,?,?)");
        preparedStatement.setString(1,instructor.getName());
        preparedStatement.setString(2,instructor.getLast_name());
        preparedStatement.setDate(3, Date.valueOf(instructor.getDate_naissance()));
        preparedStatement.setString(4,instructor.getEmail());
        preparedStatement.setString(5,instructor.getPassword());
        preparedStatement.setString(6,instructor.getCin());
        preparedStatement.setString(7,INSTRUCTOR_TYPE);

        return preparedStatement.executeUpdate();

    }
    static public int updateInstructor(String cin, Instructor instructor) throws SQLException{
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE User SET nom=?, prenom=?, date_naissance=? ,email=? ,password=?, cin=?, type=? WHERE cin=? AND type='instructor'");
        preparedStatement.setString(1,instructor.getName());
        preparedStatement.setString(2,instructor.getLast_name());
        preparedStatement.setDate(3,Date.valueOf(instructor.getDate_naissance()));
        preparedStatement.setString(4,instructor.getEmail());
        preparedStatement.setString(5,instructor.getPassword());
        preparedStatement.setString(6,instructor.getCin());
        preparedStatement.setString(7,INSTRUCTOR_TYPE);
        preparedStatement.setString(8,cin);

        return preparedStatement.executeUpdate();
    }
    static public int deleteInstructor(String cin,Instructor instructor) throws SQLException{
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM User WHERE cin=? AND type=type='instructor'");
        preparedStatement.setString(1,cin);

        return preparedStatement.executeUpdate();
    }
    public static ArrayList<Instructor> getAllInstructors() throws SQLException {
        ArrayList<Instructor> instructors = new ArrayList<>();

        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT nom, prenom, date_naissance ,email , cin FROM User WHERE type='instructor'");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("nom");
            String last_name = rs.getString("prenom");
            String email = rs.getString("email");
            LocalDate date_naissance = rs.getDate("date_naissance").toLocalDate();
            String cin = rs.getString("cin");

            Instructor instructor = new Instructor(name, last_name, email, date_naissance, cin);
            instructors.add(instructor);
        }
        rs.close();
        preparedStatement.close();
        return instructors;
    }
}
