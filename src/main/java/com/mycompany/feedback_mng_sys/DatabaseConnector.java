package com.mycompany.feedback_mng_sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection conn = null;

    public static Connection connect() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12658745";
                String user = "sql12658745";
                String password = "TPVfXCwKlf";

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
