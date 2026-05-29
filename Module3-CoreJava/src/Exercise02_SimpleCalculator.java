// Exercise 2: Simple Calculator
// Objective: Practice arithmetic operations and user input.
import java.util.Scanner;

public class Exercise02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation: + - * /");
        System.out.print("Operation: ");
        String op = scanner.next();

        double result;
        switch (op) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    scanner.close();
                    return;
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("Invalid operation.");
                scanner.close();
                return;
            }
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
