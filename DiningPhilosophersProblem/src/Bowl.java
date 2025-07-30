import java.util.concurrent.locks.ReentrantLock;

public class Bowl {
    private final ReentrantLock lock = new ReentrantLock();

    public void eat(String philosopherName) {
        lock.lock();

        try {
            System.out.println(philosopherName + " eating rice");
            Thread.sleep(1000);
            System.out.println(philosopherName + " is finished eating");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
