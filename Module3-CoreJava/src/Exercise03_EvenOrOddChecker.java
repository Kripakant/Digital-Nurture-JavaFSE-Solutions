// Exercise 3: Even or Odd Checker
// Objective: Utilize conditional statements.
import java.util.Scanner;

public class Exercise03_EvenOrOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Use the modulus operator % to check divisibility by 2.
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }

        scanner.close();
    }
}
