// Exercise 10: Number Guessing Game
// Objective: Implement loops and conditional logic.
import java.util.Random;
import java.util.Scanner;

public class Exercise10_NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100.
        int target = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("I'm thinking of a number between 1 and 100.");
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > target) {
                System.out.println("Too high! Try again.");
            } else if (guess < target) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
            }
        } while (guess != target);

        scanner.close();
    }
}
