public class StarvationExample {
    public static void main(String[] args) {
        Object sharedLock = new Object();

        Thread t1 = new Thread(new Task(sharedLock, "High Priority Task"));
        Thread t2 = new Thread(new Task(sharedLock, "Low Priority Task"));

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
