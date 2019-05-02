import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 10/07/14
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class MyCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

}
