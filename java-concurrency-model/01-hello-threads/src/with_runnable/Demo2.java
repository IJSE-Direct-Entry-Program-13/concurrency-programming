package with_runnable;

import java.util.concurrent.Executors;

public class Demo2 {

    public static void main(String[] args) {
        Runnable myTask = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println("I'm running." + this);
            }
        };
        new Thread(myTask).start();
        Thread.ofVirtual().start(myTask);
        Executors.newFixedThreadPool(1).execute(myTask);
    }
}
