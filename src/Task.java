import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    private final String name;
    private int acquires = 0;

    public Task(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                acquires++;
                if (acquires % 100 == 0) {
                    System.out.printf("%s acquired the lock (%d times)\n", name, acquires);
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
