import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 1");
            System.out.println("============");
        };
        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 2");
            if (true) throw new RuntimeException("I am an error");
            System.out.println("++++++++++++");
        };
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task 3");
            System.out.println("------------");
        };
//        new Thread(task1).start();
//        new Thread(task2).start();
//        new Thread(task3).start();
//        new Thread(()->{
//           task1.run();
//           task2.run();
//           task3.run();
//        }).start();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.execute(task1);
//        executor.execute(task2);
//        executor.execute(task3);
//         executor.shutdown();
//        ExecutorService executor2 = Executors.newFixedThreadPool(1);
//        executor2.execute(task1);
//        executor2.execute(task2);
//        executor2.execute(task3);
    }
}
