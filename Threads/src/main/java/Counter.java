import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
public class Counter {
    private static final int NTHREDS = 10;
    private AtomicInteger value = new AtomicInteger();

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 500; i++) {
            Callable<Integer> worker = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int number = counter.incrementLongVersion();
                    System.out.println(number);
                    return number;
                }
            };
            Future<Integer> submit = executor.submit(worker);
            list.add(submit);

        }


        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Future<Integer> future : list) {
            try {
                set.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        if (list.size() != set.size()) {
            throw new RuntimeException("Double-entries!!!");
        }

    }

    public int getValue() {
        return value.get();
    }

    public int increment() {
        return value.incrementAndGet();
    }

    // Alternative implementation as increment but just make the
    // implementation explicit
    public int incrementLongVersion() {
        int oldValue = value.get();
        while (!value.compareAndSet(oldValue, oldValue + 1)) {
            oldValue = value.get();
        }
        return oldValue + 1;
    }

}
