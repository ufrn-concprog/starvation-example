public class Task implements Runnable {
    private final Object lock;
    private final String name;
    private int acquires = 0;

    public Task(Object lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        do {
            synchronized (lock) {
                acquires++;
                if (acquires % 100 == 0) {
                    System.out.printf("%s acquired the lock (%d times)\n", name, acquires);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (true);
    }
}
