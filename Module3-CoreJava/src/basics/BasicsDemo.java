package basics;

import java.util.Scanner;

/**
 * Demonstrates Java basics: variables, data types, operators,
 * control flow (if/else, switch, loops) and a simple Scanner input.
 */
public class BasicsDemo {

    public static void main(String[] args) {
        // ---- Primitive data types ----
        int age = 25;
        double salary = 55000.50;
        char grade = 'A';
        boolean isActive = true;
        String name = "Trainee";

        System.out.println("=== Variables & Data Types ===");
        System.out.printf("Name=%s, Age=%d, Salary=%.2f, Grade=%c, Active=%b%n",
                name, age, salary, grade, isActive);

        // ---- Operators ----
        int a = 17, b = 5;
        System.out.println("\n=== Arithmetic Operators ===");
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " / " + b + " = " + (a / b) + " (integer division)");
        System.out.println(a + " % " + b + " = " + (a % b));

        // ---- if / else ----
        System.out.println("\n=== Conditionals ===");
        if (age >= 18) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        // ---- switch ----
        switch (grade) {
            case 'A' -> System.out.println("Excellent");
            case 'B' -> System.out.println("Good");
            default  -> System.out.println("Keep improving");
        }

        // ---- Loops ----
        System.out.println("\n=== for loop: factorial of 5 ===");
        long fact = 1;
        for (int i = 1; i <= 5; i++) {
            fact *= i;
        }
        System.out.println("5! = " + fact);

        System.out.println("\n=== while loop: countdown ===");
        int n = 3;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println("Go!");

        // ---- Scanner (commented out so it runs non-interactively) ----
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String input = sc.nextLine();
        // System.out.println("Hello, " + input);
        // sc.close();
    }
}
