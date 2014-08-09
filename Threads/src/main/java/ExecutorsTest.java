import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorsTest implements Runnable {
    private int id;

    private ExecutorsTest(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++)
            executorService.submit(new ExecutorsTest(i));
        System.out.println("All tasks submitted..");
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }
        System.out.println("All tasks completed..");
    }

    @Override
    public void run() {
        System.out.println("starting : " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        System.out.println("Completed: " + id);
    }
}
