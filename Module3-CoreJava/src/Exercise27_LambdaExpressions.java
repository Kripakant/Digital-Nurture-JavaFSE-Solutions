// Exercise 27: Lambda Expressions
// Objective: Use functional programming features.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise27_LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
                "Charlie", "Alice", "Bob", "Eve", "David"));

        System.out.println("Before sorting: " + names);

        // Sort using a lambda expression (natural order).
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("After sorting:  " + names);

        // Sort by length using another lambda.
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Sorted by length: " + names);
    }
}
