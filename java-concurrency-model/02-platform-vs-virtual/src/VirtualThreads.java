import java.util.concurrent.Executors;

public class VirtualThreads {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread());
            System.out.println("I'm running");
        };

        Thread t1 = Thread.ofVirtual().start(task);
        // new Thread(task).start();

        Executors.newVirtualThreadPerTaskExecutor().execute(task);
    }
}
