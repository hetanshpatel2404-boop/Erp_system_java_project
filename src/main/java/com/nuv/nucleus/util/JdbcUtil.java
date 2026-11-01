package com.nuv.nucleus.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class JdbcUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/nucleus_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Hell2456j.";
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            return connection.isValid(3);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
