// Exercise 40: Virtual Threads (Java 21)
// Objective: Use lightweight threads for scalable concurrency.
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise40_VirtualThreads {

    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        // ---- Virtual threads ----
        AtomicInteger vCounter = new AtomicInteger();
        long vStart = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int id = i;
            // Thread.startVirtualThread launches a lightweight virtual thread.
            virtualThreads[i] = Thread.startVirtualThread(() -> {
                vCounter.incrementAndGet();
                // Each thread does a tiny bit of work (commented print to avoid flooding).
                // System.out.println("Virtual thread " + id);
                if (id == THREAD_COUNT - 1) {
                    // print just once to show they ran
                }
            });
        }
        for (Thread t : virtualThreads) {
            t.join();
        }
        long vTime = System.currentTimeMillis() - vStart;

        System.out.println("Virtual threads completed: " + vCounter.get()
                + " in " + vTime + " ms");

        // ---- Comparison with a smaller number of platform threads ----
        // (Creating 100,000 platform threads would likely exhaust memory, so we
        //  benchmark a smaller batch to illustrate the performance difference.)
        int platformCount = 10_000;
        AtomicInteger pCounter = new AtomicInteger();
        long pStart = System.currentTimeMillis();

        Thread[] platformThreads = new Thread[platformCount];
        for (int i = 0; i < platformCount; i++) {
            platformThreads[i] = new Thread(pCounter::incrementAndGet);
            platformThreads[i].start();
        }
        for (Thread t : platformThreads) {
            t.join();
        }
        long pTime = System.currentTimeMillis() - pStart;

        System.out.println("Platform threads completed: " + pCounter.get()
                + " (" + platformCount + " threads) in " + pTime + " ms");
        System.out.println("Virtual threads scale to far higher counts with much lower overhead.");
    }
}
