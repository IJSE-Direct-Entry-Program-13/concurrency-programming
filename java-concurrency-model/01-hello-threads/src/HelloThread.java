import java.util.concurrent.Executors;

public class HelloThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Hello I am from new thread");
            }
        };
        t1.start();


//        System.out.println("Hello");
//        System.out.println("Thread: " + Thread.currentThread().getName());
        //Thread t1 = new Thread(new MyRunnable());
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        });
//        Thread t1 = new Thread(()->{
//            System.out.println("Hello");
//        });
//        MyThread t1 = new MyThread();
//        t1.start();
//        Thread t1 = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };
//        t1.start();
//        Executors.newSingleThreadExecutor().submit(new MyRunnable());
//        Executors.newSingleThreadExecutor().submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        });
//        Executors.newSingleThreadExecutor().submit(() -> System.out.println("Hello"));
    }
}

//class MyThread extends Thread {
//    @Override
//    public void run() {
//        System.out.println("Hello");
//    }
//}
//
//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello");
//    }
//}
