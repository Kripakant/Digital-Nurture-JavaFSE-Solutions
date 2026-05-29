// Exercise 29: Records
// Objective: Use the record keyword for immutable data structures (Java 16+).
import java.util.List;
import java.util.stream.Collectors;

public class Exercise29_Records {

    // A record automatically provides constructor, accessors, equals,
    // hashCode and toString.
    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 17);
        System.out.println(p1);
        System.out.println(p2);

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 17),
                new Person("Charlie", 25),
                new Person("Diana", 15));

        // Filter adults (age >= 18) using Streams.
        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
