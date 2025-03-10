package with_runnable;

import java.util.concurrent.Executors;

public class Demo1 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        t1.start();
        Thread.ofVirtual().start(new MyTask());
        Executors.newFixedThreadPool(1).execute(new MyTask());
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        System.out.println("My task is running and it is awesome");
    }
}
