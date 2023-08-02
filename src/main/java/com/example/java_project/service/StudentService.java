package com.example.java_project.service;
import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.Student;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentService {
    final static String STUDENT_TYPE="student";
    static public int addStudent(Student student) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into User(nom, prenom, date_naissance,email, password, cin, type ) values(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getLast_name());
        preparedStatement.setDate(3, Date.valueOf(student.getDate_naissance()));
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getPassword());
        preparedStatement.setString(6, student.getCin());
        preparedStatement.setString(7,STUDENT_TYPE);

        return preparedStatement.executeUpdate();

    }
    static public int updateStudent(String cin, Student student) throws SQLException{
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE User SET nom=?, prenom=?, date_naissance=? ,email=? ,password=?, cin=?, type=? WHERE cin=? AND type='student'");
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getLast_name());
        preparedStatement.setDate(3,Date.valueOf(student.getDate_naissance()));
        preparedStatement.setString(4,student.getEmail());
        preparedStatement.setString(5,student.getPassword());
        preparedStatement.setString(6,student.getCin());
        preparedStatement.setString(7,STUDENT_TYPE);
        preparedStatement.setString(8,cin);

        return preparedStatement.executeUpdate();
    }
    static public int deleteStudent(String cin,Student student) throws SQLException{
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM User WHERE cin=? AND type='student'");
        preparedStatement.setString(1,cin);

        return preparedStatement.executeUpdate();
    }
    public static ArrayList<Student> getAllStudent() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();

        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT nom, prenom, date_naissance ,email , cin FROM User WHERE type='student'");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("nom");
            String last_name = rs.getString("prenom");
            String email = rs.getString("email");
            LocalDate date_naissance = rs.getDate("date_naissance").toLocalDate();
            String cin = rs.getString("cin");

            Student student = new Student(name, last_name, email, date_naissance, cin);
            students.add(student);
        }
        rs.close();
        preparedStatement.close();
        return students;
    }
}
