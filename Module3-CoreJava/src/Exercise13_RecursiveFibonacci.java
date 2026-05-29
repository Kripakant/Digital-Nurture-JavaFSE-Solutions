// Exercise 13: Recursive Fibonacci
// Objective: Implement recursion.
import java.util.Scanner;

public class Exercise13_RecursiveFibonacci {

    // Recursive method that returns the nth Fibonacci number.
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));

        // Also display the full sequence up to n for clarity.
        System.out.print("Sequence: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        scanner.close();
    }
}
