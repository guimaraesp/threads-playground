package misc;
public class Task implements Runnable {
    private final String name;

    private final Integer[] row;

    private boolean makeDifficult;

    public Task(String name, Integer[] row) {
        this.name = name;
        this.row = row;
    }

    // This constructor is used to make the task take more time to complete
    public Task(String name, Integer[] row, boolean makeDifficult) {
        this.name = name;
        this.row = row;
        this.makeDifficult = makeDifficult;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (Integer integer : row) {
            sum += integer;
            if (makeDifficult) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        System.out.println("Sum of " + name + ": " + sum);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time of " + name + ": " + executionTime + " ms");
    }


}