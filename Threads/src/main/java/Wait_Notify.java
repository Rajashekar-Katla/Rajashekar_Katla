import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 */
public class Wait_Notify {
    private LinkedList<Integer> integers = new LinkedList<Integer>();
    private int limit = 10;
    private Object lock = new Object();

    public void waitMethod() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (integers.size() == limit) {
                    lock.wait();
                }
                integers.add(value++);
                System.out.println("waiting for notify call..");
                lock.notify();
            }
        }

    }

    public void notifyMethod() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (integers.size() == 0) {
                    lock.wait();
                }
                System.out.println("list size :" + integers.size());
                int value = integers.removeFirst();
                System.out.println("removed value==" + value);
                lock.notify();
                Thread.sleep(1000);
            }
        }

    }
}
