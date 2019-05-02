import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 11/07/14
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class Runner {
    Account account1 = new Account();
    Account account2 = new Account();
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public void first() throws InterruptedException {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            acquireLock(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) return;
                if (gotFirstLock) lock1.unlock();
                if (gotSecondLock) lock2.unlock();
            }

            Thread.sleep(1);
        }
    }

    public void second() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            acquireLock(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account balance 1: " + account1.getBalance());
        System.out.println("Account balance 2: " + account2.getBalance());
        System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
    }
}
