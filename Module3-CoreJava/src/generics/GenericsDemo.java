package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Generics: a generic class, a generic method,
 * and a bounded type parameter.
 */
public class GenericsDemo {

    public static void main(String[] args) {
        // ---- Generic class ----
        System.out.println("=== Generic class: Box<T> ===");
        Box<String> stringBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(42);
        System.out.println("stringBox: " + stringBox.get());
        System.out.println("intBox   : " + intBox.get());

        // ---- Generic method ----
        System.out.println("\n=== Generic method: printAll ===");
        List<String> names = List.of("Asha", "Vikram", "Neha");
        List<Integer> nums = List.of(10, 20, 30);
        printAll(names);
        printAll(nums);

        // ---- Bounded type parameter ----
        System.out.println("\n=== Bounded type: max of list ===");
        System.out.println("Max of nums  : " + max(new ArrayList<>(nums)));
        System.out.println("Max of names : " + max(new ArrayList<>(names)));
    }

    /** Generic method - works for any type. */
    static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /** Bounded type parameter: T must be Comparable. */
    static <T extends Comparable<T>> T max(List<T> list) {
        T maxVal = list.get(0);
        for (T item : list) {
            if (item.compareTo(maxVal) > 0) maxVal = item;
        }
        return maxVal;
    }
}

/** A simple generic container class. */
class Box<T> {
    private final T value;

    Box(T value) { this.value = value; }

    T get() { return value; }
}
