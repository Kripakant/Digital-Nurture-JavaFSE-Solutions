// Exercise 26: Thread Creation
// Objective: Implement multithreading.
public class Exercise26_ThreadCreation {

    // A class implementing Runnable that prints a message multiple times.
    static class MessagePrinter implements Runnable {
        private final String message;

        MessagePrinter(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(message + " - iteration " + i
                        + " [" + Thread.currentThread().getName() + "]");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MessagePrinter("Hello from Thread 1"), "T1");
        Thread thread2 = new Thread(new MessagePrinter("Greetings from Thread 2"), "T2");

        thread1.start();
        thread2.start();
    }
}
