// Exercise 25: HashMap Example
// Objective: Use key-value pairs.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise25_HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> students = new HashMap<>();

        System.out.print("How many student entries do you want to add? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students.put(id, name);
        }

        System.out.print("\nEnter an ID to look up: ");
        int searchId = scanner.nextInt();

        if (students.containsKey(searchId)) {
            System.out.println("Name for ID " + searchId + ": " + students.get(searchId));
        } else {
            System.out.println("No student found with ID " + searchId);
        }

        scanner.close();
    }
}
