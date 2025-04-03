package misc;

import java.util.concurrent.*;

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is running on thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + name + " completed on thread " + Thread.currentThread().getName());
    }
}

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks for execution
        for (int i = 1; i <= 5; i++) {
            executorService.submit(new Task("Task-" + i));
        }

        // Shutdown the executor
        executorService.shutdown();

        // Wait for all tasks to finish before terminating the program
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Force shutdown if tasks aren't finished
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow(); // Force shutdown on interruption
        }
    }
}
