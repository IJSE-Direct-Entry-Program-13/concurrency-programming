import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo9 {
    static volatile long lastTime = 0;
    public static void main(String[] args) {
        // CRON JOB
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 1");
            System.out.println("+++++++++++++++++++++++++++++++");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long time = System.currentTimeMillis();
            System.out.println(Math.ceil((time - lastTime) / 1000.0));
            lastTime = time;
        };
        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 2");
            System.out.println("+++++++++++++++++++++++++++++++");
        };
        ScheduledExecutorService executor =
                Executors.newSingleThreadScheduledExecutor();
        lastTime = System.currentTimeMillis();
        executor.scheduleWithFixedDelay(task1, 0,
                2, TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(task2, 0,
//                4, TimeUnit.SECONDS);
    }
}
