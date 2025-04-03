package misc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ArrayDoubler extends RecursiveAction {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 3; // Smallest chunk size

    public ArrayDoubler(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        System.out.println("thread id => " + Thread.currentThread().getId() + " is computing doubler from " + start + " to " + end);
        if (end - start <= THRESHOLD) { // Base case: Process directly
            for (int i = start; i < end; i++) {
                arr[i] *= 2;
            }
        } else {
            // Split into two subtasks
            int mid = (start + end) / 2;
            ArrayDoubler leftTask = new ArrayDoubler(arr, start, mid);
            ArrayDoubler rightTask = new ArrayDoubler(arr, mid, end);

            invokeAll(leftTask, rightTask); // Execute both tasks in parallel
        }
    }
}

public class ForkJoinRecursiveAction {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Sample array
        ForkJoinPool pool = new ForkJoinPool(); // Create ForkJoinPool

        System.out.println("Original Array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\n");

        pool.invoke(new ArrayDoubler(arr, 0, arr.length)); // Execute ForkJoinPool

        System.out.println("\nDoubled Array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
