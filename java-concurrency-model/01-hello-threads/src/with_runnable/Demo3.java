package with_runnable;

import java.util.concurrent.Executors;

public class Demo3 {

    public static void main(String[] args) {
        Runnable myTask = () -> {
            System.out.println(Thread.currentThread());
            /* Lambda expressions use lexical this */
//            System.out.println("I'm running." + this);
            System.out.println("I'm running.");
        };
        new Thread(myTask).start();
        Thread.ofVirtual().start(myTask);
        Executors.newFixedThreadPool(1).execute(myTask);
    }
}
