import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 11/07/14
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class BlockingQueue_Test {
    private static final BlockingQueue<Integer> INTEGERS = new ArrayBlockingQueue<Integer>(10);
    private static final Random RANDOM = new Random();
    private static final Wait_Notify WAIT_NOTIFY = new Wait_Notify();
    private static final ReentrantLock_Test REENTRANT_LOCK_TEST = new ReentrantLock_Test();
    private static final Runner RUNNER = new Runner();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                producer();
//                try {
//                    WAIT_NOTIFY.waitMethod();
//                    REENTRANT_LOCK_TEST.firstThread();
                try {
                    RUNNER.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                consumer();
                //                    WAIT_NOTIFY.notifyMethod();
//                try {
//                    REENTRANT_LOCK_TEST.secondThread();
                try {
                    RUNNER.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                }

            }

        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
//            REENTRANT_LOCK_TEST.finished();
            RUNNER.finished();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    private static void producer() {
        while (true)
            try {
                int i = RANDOM.nextInt(10);
                INTEGERS.put(i);
                System.out.println("put  == :" + i);
            } catch (InterruptedException e) {
            }
    }

    private static void consumer() {
        while (true)
            try {
                Thread.sleep(1000);
                System.out.println("Taken value== :" + INTEGERS.take() + "; Queue size=" + INTEGERS.size());
            } catch (InterruptedException e) {
            }
    }
}
