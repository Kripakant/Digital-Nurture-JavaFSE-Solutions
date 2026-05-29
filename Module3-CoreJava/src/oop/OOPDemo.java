package oop;

/**
 * Demonstrates the four pillars of OOP:
 * Encapsulation, Inheritance, Polymorphism, Abstraction.
 *
 * Run this file's main() to see all concepts in action.
 */
public class OOPDemo {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation ===");
        BankAccount acc = new BankAccount("AC123", 1000);
        acc.deposit(500);
        acc.withdraw(300);
        System.out.println("Balance: " + acc.getBalance());

        System.out.println("\n=== Inheritance & Polymorphism ===");
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6)
        };
        for (Shape s : shapes) {
            // runtime polymorphism: correct area() chosen at runtime
            System.out.printf("%s area = %.2f%n",
                    s.getClass().getSimpleName(), s.area());
        }
    }
}

/* ---------- Encapsulation: private fields + public methods ---------- */
class BankAccount {
    private final String accountNo;   // private = hidden state
    private double balance;

    public BankAccount(String accountNo, double opening) {
        this.accountNo = accountNo;
        this.balance = opening;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
        else System.out.println("Withdrawal denied for " + amount);
    }

    public double getBalance() { return balance; }
}

/* ---------- Abstraction: abstract base class ---------- */
abstract class Shape {
    abstract double area();   // abstract method — no body
}

/* ---------- Inheritance: subclasses extend Shape ---------- */
class Circle extends Shape {
    private final double radius;
    Circle(double radius) { this.radius = radius; }

    @Override
    double area() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private final double width, height;
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() { return width * height; }
}
