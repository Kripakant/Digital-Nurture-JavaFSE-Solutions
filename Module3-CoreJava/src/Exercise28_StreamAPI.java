// Exercise 28: Stream API
// Objective: Process collections using streams.
import java.util.List;
import java.util.stream.Collectors;

public class Exercise28_StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use the Stream API to filter even numbers.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Original list: " + numbers);
        System.out.println("Even numbers:  " + evenNumbers);

        // Bonus: sum of even numbers.
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + sum);
    }
}
