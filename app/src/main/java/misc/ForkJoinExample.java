package misc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 3; // Smallest chunk size

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println("thread id => " + Thread.currentThread().getId() + " is computing sum from " + start + " to " + end);
        if (end - start <= THRESHOLD) { // Base case: Small enough to compute directly
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        }

        // Split task into two
        int mid = (start + end) / 2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid, end);

        leftTask.fork(); // Run leftTask asynchronously
        int rightResult = rightTask.compute(); // Compute rightTask directly
        int leftResult = leftTask.join(); // Wait for leftTask

        return leftResult + rightResult; // Combine results
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; // Sample array
        ForkJoinPool pool = new ForkJoinPool(); // Create ForkJoinPool

        int sum = pool.invoke(new SumTask(arr, 0, arr.length));
        System.out.println("Sum: " + sum); // Output: 55
    }
}

