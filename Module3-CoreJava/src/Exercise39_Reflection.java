// Exercise 39: Reflection in Java
// Objective: Use Java Reflection API.
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Exercise39_Reflection {

    // A sample target class to inspect and invoke reflectively.
    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public void greet(String name) {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void main(String[] args) throws Exception {
        // Load the class by name.
        Class<?> clazz = Class.forName("Exercise39_Reflection$Calculator");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Methods of " + clazz.getSimpleName() + ":");
        for (Method method : clazz.getDeclaredMethods()) {
            StringBuilder sb = new StringBuilder("  " + method.getName() + "(");
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                sb.append(params[i].getType().getSimpleName());
                if (i < params.length - 1) sb.append(", ");
            }
            sb.append(")");
            System.out.println(sb);
        }

        // Invoke methods dynamically without referencing them directly.
        System.out.println("\nDynamic invocation:");
        Method add = clazz.getMethod("add", int.class, int.class);
        Object sum = add.invoke(instance, 7, 8);
        System.out.println("add(7, 8) = " + sum);

        Method greet = clazz.getMethod("greet", String.class);
        greet.invoke(instance, "Reflection");
    }
}
