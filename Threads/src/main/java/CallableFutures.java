import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
public class CallableFutures {
    private static final int NTHREDS = 10;
    private static int value;
    private ThreadLocal<Calendar> calendarRef = new ThreadLocal<Calendar>() {
        protected Calendar initialValue() {
            return new GregorianCalendar();
        }
    };

    static CallableFutures callableFutures = new CallableFutures(){
        protected Calendar initialValue() {
            return new GregorianCalendar();
        }
    };

    public static void main(String[] args) {

        System.out.println(callableFutures);

        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        for (int i = 0; i < 20000; i++) {
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executor.submit(worker);
            list.add(submit);
        }
        long sum = 0;
        System.out.println(list.size());
        // now retrieve the result
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        executor.shutdown();
    }
}