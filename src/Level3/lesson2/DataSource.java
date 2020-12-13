package ru.geekbrains.prev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private DataSource() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chatdb",
                    "root",
                    "root"
            );
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during getting a connection", throwables);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during closing the connection", throwables);
        }
    }
}
