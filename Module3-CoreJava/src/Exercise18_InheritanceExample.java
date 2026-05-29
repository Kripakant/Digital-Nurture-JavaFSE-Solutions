// Exercise 18: Inheritance Example
// Objective: Implement inheritance.
public class Exercise18_InheritanceExample {

    // Base class
    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    // Subclass overriding makeSound()
    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.makeSound(); // Some generic animal sound
        dog.makeSound();    // Bark
    }
}
