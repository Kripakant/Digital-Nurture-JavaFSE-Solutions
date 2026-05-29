// Exercise 20: Try-Catch Example
// Objective: Handle exceptions gracefully.
import java.util.Scanner;

public class Exercise20_TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int a = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int b = scanner.nextInt();

        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero! (" + e.getMessage() + ")");
        }

        scanner.close();
    }
}
