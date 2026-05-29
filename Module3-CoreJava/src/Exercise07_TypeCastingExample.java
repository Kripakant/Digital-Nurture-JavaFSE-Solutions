// Exercise 7: Type Casting Example
// Objective: Practice type casting between different data types.
public class Exercise07_TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double and cast it to an int (narrowing / explicit cast).
        double myDouble = 9.78;
        int castedInt = (int) myDouble;
        System.out.println("Original double: " + myDouble);
        System.out.println("After casting to int: " + castedInt);

        // Declare an int and cast it to a double (widening / implicit cast).
        int myInt = 42;
        double castedDouble = (double) myInt;
        System.out.println("\nOriginal int: " + myInt);
        System.out.println("After casting to double: " + castedDouble);
    }
}
