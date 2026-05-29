// Exercise 12: Method Overloading
// Objective: Understand method overloading in Java.
public class Exercise12_MethodOverloading {

    // Two integers
    public static int add(int a, int b) {
        return a + b;
    }

    // Two doubles
    public static double add(double a, double b) {
        return a + b;
    }

    // Three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("add(5, 10) = " + add(5, 10));
        System.out.println("add(2.5, 3.7) = " + add(2.5, 3.7));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
    }
}
