package com.example.rmcserviceapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:rmcdata.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String customerTable = """
            CREATE TABLE IF NOT EXISTS customers (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                date TEXT,
                time TEXT,
                order_no TEXT,
                name TEXT,
                address TEXT,
                contact TEXT,
                site_name TEXT
            );
        """;

        String materialTable = """
            CREATE TABLE IF NOT EXISTS materials (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                order_no TEXT,
                dust_set REAL,
                dust_actual REAL,
                agg_set REAL,
                agg_actual REAL,
                cement_set REAL,
                cement_actual REAL
            );
        """;

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(customerTable);
            stmt.execute(materialTable);
        } catch (SQLException e) {
            System.err.println("Database initialization error: " + e.getMessage());
        }
    }
}
