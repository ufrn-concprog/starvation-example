import java.util.concurrent.locks.ReentrantLock;

public class StarvationExample {
    public static void main(String[] args) {
        ReentrantLock sharedLock = new ReentrantLock();

        Runnable highPriorityTask = new Task(sharedLock, "HighPriorityTask");
        Runnable lowPriorityTask = new Task(sharedLock, "LowPriorityTask");

        Thread t1 = new Thread(highPriorityTask);
        Thread t2 = new Thread(lowPriorityTask);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
