import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
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
//        new Thread(()->{
//            try {
//                task1.run();
//            }catch (Exception e){}
//            try {
//                task2.run();
//            }catch (Exception e){}
//            try {
//                task3.run();
//            }catch (Exception e){}
//        }).start();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> task1Future = executor.submit(task1);
        Future<?> task2Future = executor.submit(task2);
        Future<?> task3Future = executor.submit(task3);
        executor.shutdown();
        while (!executor.isTerminated()) Thread.onSpinWait();
        System.out.println("=========RESULT===============");
        System.out.println("Task1 done: " + task1Future.isDone());
        System.out.println("Task2 done: " + task2Future.isDone());
        System.out.println("Task3 done: " + task3Future.isDone());
        System.out.println("================================");
        System.out.println("Task1 result: " + task1Future.get());
//        System.out.println("Task1 done: " + task1Future.exceptionNow());
//        System.out.println("Task2 result: " + task2Future.get());
        System.out.println("Task2 exception: " + task2Future.exceptionNow());
        System.out.println("Task3 result: " + task3Future.get());
//        System.out.println("Task3 done: " + task3Future.exceptionNow());
    }
}
