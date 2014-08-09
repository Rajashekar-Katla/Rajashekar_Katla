package countdown_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
public class CountDownLatch_Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for(int i=0;i<4;i++){
        Thread thread1 = new Thread(new Service("first", 1, countDownLatch));
        Thread thread2 = new Thread(new Service("second", 2, countDownLatch));
        Thread thread3 = new Thread(new Service("third", 3, countDownLatch));
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

        countDownLatch.await();
        System.out.println("All services up..");
    }
}
