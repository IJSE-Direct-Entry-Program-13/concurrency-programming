import java.util.concurrent.Executors;

public class PlatformThreads {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread());
            System.out.println("I'm running");
        };
        Thread.ofPlatform().start(task);

        Executors.newSingleThreadExecutor().execute(task);
        Executors.newFixedThreadPool(5).submit(task);
//        Executors.newFixedThreadPool(5).submit(task);
    }
}
