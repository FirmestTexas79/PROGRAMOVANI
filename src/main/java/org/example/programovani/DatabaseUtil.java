package org.example.programovani;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3307/test";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "mp";

    public static Connection getConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}