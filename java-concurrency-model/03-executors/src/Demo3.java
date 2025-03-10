import java.util.concurrent.*;

public class Demo3 {

    public static void main(String[] args) {
        Callable<Integer> task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 1");
            return 10;
        };
        Callable<String> task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 2");
            return "This is awesome";
        };
        Callable<Boolean> task3 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 3");
            return true;
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        Future<Boolean> future3 = executor.submit(task3);
        Runnable task4 = () -> {
            try {
                System.out.println(future1.get());
                System.out.println(future2.get());
                System.out.println(future3.get());
            } catch (Exception e) {}
        };
        executor.submit(task4);
    }
}
