package com.example.java_project.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    final private String url = "jdbc:mysql://localhost/school";
    //final private String DataBase="school";
    final private String UserName="root";
    final private String Password="";
    private Connection conn ;
    static DbConnection instance=new DbConnection();

    /*public DbConnection()  {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =
                DriverManager.getConnection("jdbc:mysql://localhost/" +DataBase+
                        "?user="+UserName+"&password="+Password);

    } catch (Exception e){
        throw new RuntimeException(e.getMessage());
        }
    }*/
    public DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,UserName, Password);
            System.out.println("connexion to database established successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }
}
