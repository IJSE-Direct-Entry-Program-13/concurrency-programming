import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo10 {

    volatile static int counter = 0;
    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println("Task:" + Thread.currentThread().getName());
            if (counter++  == 1) {
                try {
                    System.out.println(Thread.currentThread().getName()
                            + " about to suspend");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()
                            + " just resumed");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        ScheduledExecutorService executor = Executors
                .newScheduledThreadPool(10);
//        executor.scheduleAtFixedRate(task1, 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.SECONDS);
    }
}
