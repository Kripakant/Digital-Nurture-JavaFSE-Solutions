// Exercise 32: Insert and Update Operations in JDBC
// Objective: Perform insert/update SQL queries from Java.
//
// Uses the same `students` table as Exercise 31.
// Compiles with java.sql.* only; needs MySQL Connector/J on classpath to run.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercise32_InsertAndUpdateJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Data Access Object encapsulating insert/update logic.
    static class StudentDAO {
        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        // Insert a new student using a parameterized PreparedStatement.
        public void insertStudent(String name, String grade) throws SQLException {
            String sql = "INSERT INTO students (name, grade) VALUES (?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, grade);
                int rows = ps.executeUpdate();
                System.out.println("Inserted " + rows + " row(s).");
            }
        }

        // Update an existing student's grade by id.
        public void updateStudentGrade(int id, String newGrade) throws SQLException {
            String sql = "UPDATE students SET grade = ? WHERE id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, newGrade);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                System.out.println("Updated " + rows + " row(s).");
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

        StudentDAO dao = new StudentDAO();
        try {
            dao.insertStudent("Charlie", "A");
            dao.updateStudentGrade(1, "A+");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
