package countdown_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 12/07/14
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class Service implements Runnable {
    private String name;
    private int count;
    private CountDownLatch countDownLatch;

    public Service(String name, int count, CountDownLatch countDownLatch) {
        this.name = name;
        this.count = count;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(name + " service initialized..");
        countDownLatch.countDown();
    }
}
