import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo7 {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 1");
            System.out.println("+++++++++++++++++++++++++++++++");
        };
        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 2");
            System.out.println("+++++++++++++++++++++++++++++++");
        };
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 3");
            System.out.println("+++++++++++++++++++++++++++++++");
        };
        Runnable task4 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task 4");
            System.out.println("+++++++++++++++++++++++++++++++");
        };
        ScheduledExecutorService executor = Executors
//                .newSingleThreadScheduledExecutor();
                .newScheduledThreadPool(5);
        executor.schedule(task1, 5, TimeUnit.SECONDS);
        executor.schedule(task2, 10, TimeUnit.SECONDS);
        executor.schedule(task3, 10, TimeUnit.SECONDS);
        executor.schedule(task4, 5, TimeUnit.SECONDS);
    }
}
