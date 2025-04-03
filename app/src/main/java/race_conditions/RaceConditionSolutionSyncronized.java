
public class RaceConditionSolutionSyncronized {
    private static int counter = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (lock) { // lock to ensure only one thread can access this block at a time
                    counter++;
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter Value: " + counter);
        // counter should be 2_000_000
        // but due to the race condition the result is not consistent
        // counter++ is not atomic
        // and can be interrupted by another thread (reads the value, increments it, and writes it back)
        // this can lead to a situation where both threads read the same value and write it back

    }
}