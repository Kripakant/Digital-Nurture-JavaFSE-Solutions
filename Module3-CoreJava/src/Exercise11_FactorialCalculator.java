// Exercise 11: Factorial Calculator
// Objective: Use loops to perform repetitive calculations.
import java.util.Scanner;

public class Exercise11_FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            // Use a for loop to calculate the factorial.
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println(n + "! = " + factorial);
        }

        scanner.close();
    }
}
