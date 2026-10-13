package com.portlogix.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/portlogix";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "root";

    public static Connection getConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("=================================");
            System.out.println("MySQL Database Connected!");
            System.out.println("Database: portlogix");
            System.out.println("=================================");

            return connection;

        } catch (SQLException e) {

            System.out.println("=================================");
            System.out.println("Database Connection Failed!");
            System.out.println("=================================");

            e.printStackTrace();

            return null;
        }
    }

    public static void main(String[] args) {

        Connection connection = getConnection();

        if (connection != null) {

            System.out.println("Connection test successful!");

            try {
                connection.close();
                System.out.println("Connection closed.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}