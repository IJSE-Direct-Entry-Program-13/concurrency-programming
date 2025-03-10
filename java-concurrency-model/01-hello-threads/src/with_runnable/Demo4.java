package with_runnable;

import java.util.concurrent.Executors;

public class Demo4 {

    public static void main(String[] args) {
        Runnable myTask = Demo4::executeMyTask;
        new Thread(myTask).start();
        Thread.ofVirtual().start(myTask);
        Executors.newFixedThreadPool(1).execute(myTask);
    }

    public static void executeMyTask(){
        System.out.println(Thread.currentThread());
        System.out.println("I'm running");
    }
}
