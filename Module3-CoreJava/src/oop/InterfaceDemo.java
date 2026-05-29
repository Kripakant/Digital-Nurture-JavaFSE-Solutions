package oop;

/**
 * Demonstrates an interface, default methods, and implementing it.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment(),
            new UpiPayment()
        };
        for (Payment p : payments) {
            p.pay(1500);
            p.receipt();          // default method
        }
    }
}

interface Payment {
    void pay(double amount);          // abstract

    default void receipt() {          // default method (Java 8+)
        System.out.println("  -> Receipt generated.\n");
    }
}

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card.");
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI.");
    }
}
