package SemaphoreTest;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 12/07/14
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
public class Connection {
    private static final Connection connection = new Connection();
    private int connections = 0;
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public static Connection geConnection() {
        return connection;
    }

    public void connect() {
        try {
            semaphore.acquire();
            doConnect();
        } catch (InterruptedException e) {
        } finally {
            semaphore.release();
        }
    }

    public void doConnect() throws InterruptedException {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }
        Thread.sleep(2000);
        synchronized (this) {
            connections--;
        }
    }
}
