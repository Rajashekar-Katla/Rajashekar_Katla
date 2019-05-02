import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 08/07/14
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
        CallableImpl callable = new Test().new CallableImpl();
        FutureTask<Double> futureTask = new FutureTask<Double>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        lock.unlock();

    }

    private class CallableImpl implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            return 2.0;
        }
    }
}
