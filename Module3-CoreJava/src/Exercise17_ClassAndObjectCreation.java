// Exercise 17: Class and Object Creation
// Objective: Understand classes and objects.
public class Exercise17_ClassAndObjectCreation {

    // Supporting type defined as a nested static class to avoid name clashes.
    static class Car {
        String make;
        String model;
        int year;

        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        void displayDetails() {
            System.out.println("Car: " + year + " " + make + " " + model);
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2022);
        Car car2 = new Car("Tesla", "Model 3", 2024);

        car1.displayDetails();
        car2.displayDetails();
    }
}
