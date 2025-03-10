import java.util.concurrent.*;

public class Demo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = ()->{
            String str = "Happy";
            Thread.sleep(500);
            str += "Birthday";
            Thread.sleep(2500);
            str += "Apea Harshaa...!";
            return str;
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> taskFuture = executor.submit(task);
        System.out.println("Is task done? :" + taskFuture.isDone());
        System.out.println("Main thread: Let's get the result, who knows how long it will take?");
        System.out.println("Result :" + taskFuture.get());
        System.out.println("Main thread: I got the result, so I can resume");
        System.out.println("Main thread: Oh no, I have to die, what a cruel world");
    }
}
