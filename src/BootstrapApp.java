import java.util.Random;

public class BootstrapApp {


    public static void main(String[] args) throws InterruptedException {

        final int size = 5;

        Integer[][] matrix = new Integer[size][size];

        fillMatrix(matrix);

        // To avoid hardcoding all the threads, we can use an array of threads
        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            Task task = new Task("Task " + (i + 1), matrix[i]);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // This will wait for all threads to finish before killing the main thread
        for (Thread thread : threads) {
            thread.join();
        }


    }

    private static void fillMatrix(Integer[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
//                System.out.println("Matrix[" + i + "][" + j + "] = " + matrix[i][j]);
            }
        }
    }

}
