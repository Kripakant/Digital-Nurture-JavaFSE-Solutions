// Exercise 4: Leap Year Checker
// Objective: Apply nested conditional logic.
import java.util.Scanner;

public class Exercise04_LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // A year is a leap year if divisible by 4 but not by 100,
        // unless it is also divisible by 400.
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                isLeap = (year % 400 == 0);
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }

        if (isLeap) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

        scanner.close();
    }
}
