// Exercise 41: Executor Service and Callable
// Objective: Use concurrency utilities.
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise41_ExecutorServiceCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool with 3 worker threads.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = new ArrayList<>();
        // Each Callable computes the square of a number and returns it.
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            tasks.add(() -> {
                System.out.println("Computing square of " + n
                        + " on " + Thread.currentThread().getName());
                Thread.sleep(100); // simulate work
                return n * n;
            });
        }

        // Submit each task and keep the returned Future.
        List<Future<Integer>> futures = new ArrayList<>();
        for (Callable<Integer> task : tasks) {
            futures.add(executor.submit(task));
        }

        // Collect results using Future.get().
        int total = 0;
        for (Future<Integer> future : futures) {
            int result = future.get();
            System.out.println("Result: " + result);
            total += result;
        }
        System.out.println("Sum of squares: " + total);

        // Always shut the executor down.
        executor.shutdown();
    }
}
