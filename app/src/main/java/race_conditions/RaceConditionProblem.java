
public class RaceConditionProblem {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
                if (i % 100 == 0) Thread.yield(); // yield to allow other threads to run
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
                if (i % 100 == 0) Thread.yield(); // yield to allow other threads to run
            }
        });

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