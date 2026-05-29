// Exercise 22: File Writing
// Objective: Write data to a file.
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise22_FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to write to output.txt: ");
        String input = scanner.nextLine();

        // try-with-resources ensures the writer is closed automatically.
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(input);
            System.out.println("Data has been written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file: " + e.getMessage());
        }

        scanner.close();
    }
}
