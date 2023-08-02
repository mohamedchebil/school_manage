package com.example.java_project.service;
import com.example.java_project.DB.DbConnection;
import com.example.java_project.dao.Feedback;
import com.example.java_project.dao.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectService {
    static public int addProject(Project project) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into project(name,decription,submitted,evaluated ) values(?,?,?,?)");
        preparedStatement.setString(1, project.getName());
        preparedStatement.setString(2, project.getDescription());
        preparedStatement.setBoolean(3,project.isSubmitted());
        preparedStatement.setBoolean(4,project.isEvaluated());

        return preparedStatement.executeUpdate();
    }
    static public int updateProject(String name,Project project) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Project SET name=?, decription=?, submitted=? ,evaluated=?");
        preparedStatement.setString(1,project.getName());
        preparedStatement.setString(2,project.getDescription());
        preparedStatement.setBoolean(3,project.isSubmitted());
        preparedStatement.setBoolean(4,project.isEvaluated());

        return preparedStatement.executeUpdate();
    }
    static public int deleteProject(String name) throws SQLException {
        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Project WHERE name=?");
        preparedStatement.setString(1,name);

        return preparedStatement.executeUpdate();
    }
    public static ArrayList<Project> getAllProjects() throws SQLException {
        ArrayList<Project> projects = new ArrayList<>();

        Connection conn = DbConnection.getInstance().getConn();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT name, decription, submitted, evaluated FROM Project");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String decription = rs.getString("decription");
            boolean submitted = rs.getBoolean("submitted");
            boolean evaluated = rs.getBoolean("evaluated");


            Project project = new Project(name, decription, submitted, evaluated);
            projects.add(project);
        }
        rs.close();
        preparedStatement.close();
        return projects;
    }

}
