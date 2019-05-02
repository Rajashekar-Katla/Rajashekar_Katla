package futures;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 12/07/14
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) {
        final int count = 200;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                for (int i = 0; i < 1E1; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interrupted..");
                        break;
                    }
                    System.out.println("i==" + i);
                }
                return null;
            }
        });
        executorService.shutdown();
//        future.cancel(true);
//        executorService.shutdownNow();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
