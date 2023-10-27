package com.mycompany.feedback_mng_sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection conn = null;

    public static Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12656946";
                String user = "sql12656946";
                String password = "nhJUSwk2B3";

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
