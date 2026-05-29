package collections;

import java.util.*;

/**
 * Demonstrates the Java Collections Framework:
 * List, Set, Map, Queue, iteration, sorting and common operations.
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        listDemo();
        setDemo();
        mapDemo();
        queueDemo();
        sortingDemo();
    }

    /* ---------- List (ArrayList) ---------- */
    static void listDemo() {
        System.out.println("=== List (ArrayList) ===");
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");                 // duplicates allowed
        System.out.println("List: " + fruits);
        System.out.println("Index of Cherry: " + fruits.indexOf("Cherry"));
        fruits.remove("Banana");
        System.out.println("After remove: " + fruits);
        System.out.println();
    }

    /* ---------- Set (HashSet) ---------- */
    static void setDemo() {
        System.out.println("=== Set (HashSet) ===");
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 2, 3, 3, 3));
        System.out.println("Unique numbers: " + numbers);   // duplicates removed

        Set<Integer> sorted = new TreeSet<>(numbers);       // TreeSet keeps order
        System.out.println("Sorted (TreeSet): " + sorted);
        System.out.println();
    }

    /* ---------- Map (HashMap) ---------- */
    static void mapDemo() {
        System.out.println("=== Map (HashMap) ===");
        Map<String, Integer> stock = new HashMap<>();
        stock.put("Pen", 50);
        stock.put("Notebook", 30);
        stock.put("Eraser", 100);

        // iterate entries
        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            System.out.println(e.getKey() + " => " + e.getValue());
        }
        System.out.println("Contains 'Pen'? " + stock.containsKey("Pen"));
        stock.merge("Pen", 10, Integer::sum);    // increment value
        System.out.println("Pen after restock: " + stock.get("Pen"));
        System.out.println();
    }

    /* ---------- Queue (LinkedList as Queue) ---------- */
    static void queueDemo() {
        System.out.println("=== Queue (FIFO) ===");
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task1");
        queue.offer("Task2");
        queue.offer("Task3");
        System.out.println("Queue: " + queue);
        System.out.println("Processing: " + queue.poll());   // removes head
        System.out.println("Next in line: " + queue.peek());
        System.out.println();
    }

    /* ---------- Sorting with Comparator ---------- */
    static void sortingDemo() {
        System.out.println("=== Sorting with Comparator ===");
        List<String> names = new ArrayList<>(
                Arrays.asList("Charlie", "alice", "Bob", "dave"));

        Collections.sort(names);                       // natural order
        System.out.println("Natural: " + names);

        names.sort(String.CASE_INSENSITIVE_ORDER);     // case-insensitive
        System.out.println("Case-insensitive: " + names);

        names.sort(Comparator.comparingInt(String::length));  // by length
        System.out.println("By length: " + names);
    }
}
