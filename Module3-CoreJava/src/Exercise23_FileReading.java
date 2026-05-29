// Exercise 23: File Reading
// Objective: Read data from a file.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise23_FileReading {
    public static void main(String[] args) {
        // Open output.txt for reading and display each line.
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            System.out.println("Contents of output.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
