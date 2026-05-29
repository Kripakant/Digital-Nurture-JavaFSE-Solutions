// Exercise 31: Basic JDBC Connection
// Objective: Connect Java with a relational database.
//
// SETUP (run in MySQL before executing this program):
//   CREATE DATABASE school;
//   USE school;
//   CREATE TABLE students (
//       id INT PRIMARY KEY AUTO_INCREMENT,
//       name VARCHAR(100),
//       grade VARCHAR(10)
//   );
//   INSERT INTO students (name, grade) VALUES ('Alice', 'A'), ('Bob', 'B');
//
// NOTE: This file compiles without a vendor driver because it only references
//       java.sql.* interfaces. To RUN it, place the MySQL Connector/J JAR on
//       the classpath, e.g.:
//   java -cp out:mysql-connector-j.jar Exercise31_BasicJDBCConnection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise31_BasicJDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Load the JDBC driver reflectively so this class compiles without it.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found on classpath: " + e.getMessage());
            return;
        }

        // try-with-resources closes Connection, Statement and ResultSet.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, grade FROM students")) {

            System.out.println("Students:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                System.out.println(id + " | " + name + " | " + grade);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
