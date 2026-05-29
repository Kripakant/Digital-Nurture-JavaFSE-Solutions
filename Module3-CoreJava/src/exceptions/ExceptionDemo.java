package exceptions;

/**
 * Demonstrates exception handling: try/catch/finally, multiple catch,
 * throw, custom exceptions and try-with-resources.
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        basicTryCatch();
        multipleCatch();
        customException();
        finallyDemo();
    }

    /* ---------- Basic try / catch ---------- */
    static void basicTryCatch() {
        System.out.println("=== Basic try/catch ===");
        try {
            int result = 10 / 0;                 // ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();
    }

    /* ---------- Multiple catch blocks ---------- */
    static void multipleCatch() {
        System.out.println("=== Multiple catch ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);          // ArrayIndexOutOfBounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array problem: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General problem: " + e.getMessage());
        }
        System.out.println();
    }

    /* ---------- Custom (checked) exception with throw ---------- */
    static void customException() {
        System.out.println("=== Custom exception ===");
        try {
            withdraw(1000, 1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught custom: " + e.getMessage());
        }
        System.out.println();
    }

    static void withdraw(double balance, double amount)
            throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + "; balance is " + balance);
        }
        System.out.println("Withdrawal successful.");
    }

    /* ---------- finally always executes ---------- */
    static void finallyDemo() {
        System.out.println("=== finally block ===");
        try {
            System.out.println("In try");
            return;                              // even with return...
        } finally {
            System.out.println("finally runs anyway"); // ...this still runs
        }
    }
}

/** Custom checked exception. */
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
