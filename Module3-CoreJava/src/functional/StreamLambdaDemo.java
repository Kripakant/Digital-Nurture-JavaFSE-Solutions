package functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Demonstrates Java 8+ functional features:
 * lambdas, functional interfaces, method references and the Stream API.
 */
public class StreamLambdaDemo {

    public static void main(String[] args) {
        lambdaDemo();
        streamDemo();
        collectorsDemo();
    }

    /* ---------- Lambdas & functional interfaces ---------- */
    static void lambdaDemo() {
        System.out.println("=== Lambdas & Functional Interfaces ===");

        Runnable r = () -> System.out.println("Running a lambda Runnable");
        r.run();

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        Function<String, Integer> length = String::length;   // method reference
        System.out.println("Length of 'Java': " + length.apply("Java"));

        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println("3 + 7 = " + add.apply(3, 7));

        Consumer<String> printer = System.out::println;
        printer.accept("Consumed by a Consumer");
        System.out.println();
    }

    /* ---------- Stream API ---------- */
    static void streamDemo() {
        System.out.println("=== Stream API ===");
        List<Integer> numbers = Arrays.asList(5, 12, 8, 130, 44, 3, 7);

        // filter + map + collect
        List<Integer> evensDoubled = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Even numbers doubled: " + evensDoubled);

        // reduce: sum
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // count, max, sorted
        long bigCount = numbers.stream().filter(n -> n > 10).count();
        System.out.println("Count > 10: " + bigCount);
        System.out.println("Max: " + numbers.stream().max(Integer::compare).orElse(-1));
        System.out.println("Sorted desc: " +
                numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println();
    }

    /* ---------- Collectors: grouping & joining ---------- */
    static void collectorsDemo() {
        System.out.println("=== Collectors ===");
        List<String> words = Arrays.asList(
                "apple", "banana", "avocado", "cherry", "blueberry");

        // group by first letter
        Map<Character, List<String>> byFirst = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println("Grouped by first letter: " + byFirst);

        // join into a single string
        String joined = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined: " + joined);

        // average length
        double avgLen = words.stream()
                .collect(Collectors.averagingInt(String::length));
        System.out.println("Average word length: " + avgLen);
    }
}
