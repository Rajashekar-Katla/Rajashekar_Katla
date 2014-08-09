import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 11/07/14
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class ReentrantLock_Test {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int value = 0;

    private void inrement() {
        for (int i = 0; i < 100; i++) value++;
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("waiting for signal..");
        condition.await();
        System.out.println("got signal..");
        try {
            inrement();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();
        System.out.println("before calling signal..");
        new Scanner(System.in).nextLine();
        System.out.println("press enter key..");
        condition.signal();
        try {
            inrement();
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Value==" + value);
    }

}
