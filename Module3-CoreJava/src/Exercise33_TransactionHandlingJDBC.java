// Exercise 33: Transaction Handling in JDBC
// Objective: Use JDBC transactions to simulate a money transfer.
//
// SETUP (run in MySQL before executing):
//   USE school;
//   CREATE TABLE accounts (
//       id INT PRIMARY KEY,
//       owner VARCHAR(100),
//       balance DECIMAL(10,2)
//   );
//   INSERT INTO accounts VALUES (1, 'Alice', 1000.00), (2, 'Bob', 500.00);
//
// Compiles with java.sql.* only; needs MySQL Connector/J on classpath to run.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise33_TransactionHandlingJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Transfer money between two accounts atomically.
    static void transfer(int fromId, int toId, double amount) throws SQLException {
        String debit = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false); // Begin transaction.

            try (PreparedStatement debitPs = conn.prepareStatement(debit);
                 PreparedStatement creditPs = conn.prepareStatement(credit)) {

                debitPs.setDouble(1, amount);
                debitPs.setInt(2, fromId);
                debitPs.executeUpdate();

                creditPs.setDouble(1, amount);
                creditPs.setInt(2, toId);
                creditPs.executeUpdate();

                conn.commit(); // Both succeeded -> commit.
                System.out.println("Transfer of " + amount + " committed successfully.");
            } catch (SQLException inner) {
                conn.rollback(); // Something failed -> rollback.
                System.out.println("Transfer failed, transaction rolled back: " + inner.getMessage());
            }
        } finally {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found on classpath: " + e.getMessage());
            return;
        }

        try {
            transfer(1, 2, 200.00);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
