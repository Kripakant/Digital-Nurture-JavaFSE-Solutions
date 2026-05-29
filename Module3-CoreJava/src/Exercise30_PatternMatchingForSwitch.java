// Exercise 30: Pattern Matching for switch (Java 21)
// Objective: Simplify conditional logic with pattern matching in switch.
public class Exercise30_PatternMatchingForSwitch {

    static String describe(Object obj) {
        // Pattern matching for switch (standardized in Java 21).
        return switch (obj) {
            case Integer i -> "Integer with value " + i;
            case String s  -> "String of length " + s.length() + ": \"" + s + "\"";
            case Double d  -> "Double with value " + d;
            case null      -> "A null reference";
            default        -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        Object[] objects = {42, "Hello", 3.14, 100L, null};

        for (Object obj : objects) {
            System.out.println(describe(obj));
        }
    }
}
