// Exercise 8: Operator Precedence
// Objective: Explore how Java evaluates expressions.
public class Exercise08_OperatorPrecedence {
    public static void main(String[] args) {
        // Multiplication has higher precedence than addition.
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1
                + "  (5*2=10 first, then 10+10)");

        // Parentheses override default precedence.
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2
                + "  (10+5=15 first, then 15*2)");

        // Mix of operators: *, / and % share precedence (left to right),
        // higher than + and -.
        int result3 = 100 - 20 / 4 + 3 * 2;
        System.out.println("100 - 20 / 4 + 3 * 2 = " + result3
                + "  (20/4=5, 3*2=6, then 100-5+6)");

        // Boolean operator precedence: && before ||.
        boolean result4 = true || false && false;
        System.out.println("true || false && false = " + result4
                + "  (&& evaluated before ||)");
    }
}
