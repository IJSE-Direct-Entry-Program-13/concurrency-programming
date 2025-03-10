package without_runnable;

public class Demo1 {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

/* This is a named Thread Extension */
class MyThread extends Thread{

    @Override
    public void run() {
        // Your task goes here
        System.out.println(Thread.currentThread());
        System.out.println("My thread is running and it is awesome");
    }
}
