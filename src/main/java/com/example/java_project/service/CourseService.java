package com.example.java_project.service;
import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    static public int addCourse(Course course) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into Course(name) values(?)");
        preparedStatement.setString(1, course.getName());

        return preparedStatement.executeUpdate();
    }
    static public int updateCourse(Course course,int id) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE User SET name=?");
        preparedStatement.setString(1,course.getName());

        return preparedStatement.executeUpdate();
    }

    static public int deleteCourse(int id) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Course WHERE id=?");
        preparedStatement.setInt(1,id);

        return preparedStatement.executeUpdate();
    }
    public static List<Course> getAllCourses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();

        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, name FROM Course");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            Course course = new Course(id, name);
            courses.add(course);
        }
        rs.close();
        preparedStatement.close();
        return courses;
    }
}
