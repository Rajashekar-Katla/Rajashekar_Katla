import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static final int NTHREDS = 10;

    public static void main(String[] args) {
        // We will store the threads so that we can check if they are done
//        System.out.println("Number of processors1=="+Runtime.getRuntime().availableProcessors());
//        List<Thread> threads = new ArrayList<Thread>();
//        // We will create 500 threads
//        for (int i = 0; i <15000; i++) {
//            Runnable task = new MyRunnable(10000000L + i);
//            Thread worker = new Thread(task);
//            // We can set the name of the thread
//            worker.setName(String.valueOf(i));
//            // Start the thread, never call method run() direct
//            worker.start();
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
////            }
//            // Remember the thread for later usage
//            threads.add(worker);
//        }
//        System.out.println("Number of processors2=="+Runtime.getRuntime().availableProcessors());
//        System.out.println("total threads=="+threads.size());
//        int running = 0;
//        do {
//            running = 0;
//            for (Thread thread : threads) {
//                if (thread.isAlive()) {
//                    ++running;
//                }
//            }
//            System.out.println("We have " + running + " running threads. ");
//        } while (running > 0);

            ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
            for (int i = 0; i < 15000; i++) {
                Runnable worker = new MyRunnable(10000000L + i);
                executor.execute(worker);
            }
            // This will make the executor accept no new threads
            // and finish all existing threads in the queue
            executor.shutdown();
            // Wait until all threads are finish
        try {
            executor.awaitTermination(1L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Finished all threads");

    }
}
