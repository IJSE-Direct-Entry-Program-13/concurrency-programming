import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
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
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
    }
}
