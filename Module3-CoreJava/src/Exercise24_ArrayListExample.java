// Exercise 24: ArrayList Example
// Objective: Use dynamic arrays.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise24_ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("How many student names do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }

        System.out.println("\nStudent names entered:");
        for (String name : names) {
            System.out.println("- " + name);
        }

        scanner.close();
    }
}
