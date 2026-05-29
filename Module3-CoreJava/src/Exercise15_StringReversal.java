// Exercise 15: String Reversal
// Objective: Manipulate strings.
import java.util.Scanner;

public class Exercise15_StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use StringBuilder to reverse the string.
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("Reversed string: " + reversed);
        scanner.close();
    }
}
