// Exercise 14: Array Sum and Average
// Objective: Work with arrays and perform calculations.
import java.util.Scanner;

public class Exercise14_ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int count = scanner.nextInt();

        int[] numbers = new int[count];
        System.out.println("Enter " + count + " integers:");
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int value : numbers) {
            sum += value;
        }
        double average = (count == 0) ? 0 : (double) sum / count;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}
