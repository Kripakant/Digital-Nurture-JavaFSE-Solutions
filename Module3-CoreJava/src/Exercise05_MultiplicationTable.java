// Exercise 5: Multiplication Table
// Objective: Implement loops.
import java.util.Scanner;

public class Exercise05_MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Multiplication table for " + number + ":");
        // Use a for loop to iterate from 1 to 10.
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}
