package com.example.society360;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {

    // Change your IP, Database name, User and Password here
    private static final String URL = "jdbc:mysql://10.0.2.2:3306/society360"; // Emulator ke liye 10.0.2.2
    private static final String USER = "root";
    private static final String PASSWORD = "adi@123";

    // Connect to database
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Fetch residents' names
    public static ResultSet getResidents() {
        ResultSet rs = null;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM residents");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Fetch Security Guard Info
    public static ResultSet getGuards() {
        ResultSet rs = null;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT name, phone FROM guards");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Book Hall
    public static boolean bookHall(String username, String date) {
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("INSERT INTO hall_booking (username, booking_date) VALUES ('" + username + "', '" + date + "')");
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Pay Maintenance
    public static boolean payMaintenance(String username, double amount) {
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate("INSERT INTO payments (username, amount, status) VALUES ('" + username + "', " + amount + ", 'Paid')");
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
