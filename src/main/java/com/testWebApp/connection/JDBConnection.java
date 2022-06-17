package com.testWebApp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/social";
    private static final String JDBC_NAME = "root";
    private static final String JDBC_PASSWORD = "170299Artem_";
    private Connection connection;

    public java.sql.Connection getConnection() throws ClassNotFoundException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_NAME, JDBC_PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }return connection;
    }
}
