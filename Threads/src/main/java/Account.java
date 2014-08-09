/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 11/07/14
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private int balance = 10000;

    private void deposit(int amount) {
        balance += amount;
    }

    private void withDraw(int amount) {
        balance -= amount;
    }

    public static void transfer(Account from, Account to, int amount) {
        from.withDraw(amount);
        to.deposit(amount);
    }

    public int getBalance() {
        return balance;
    }
}
