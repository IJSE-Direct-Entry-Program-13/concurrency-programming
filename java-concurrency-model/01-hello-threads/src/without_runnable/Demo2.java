package without_runnable;

public class Demo2 {

    public static void main(String[] args) {
        /* This is anonymous Thread extension */
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println("I have no name but I am still awesome");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println("I have no name but I am still awesome");
            }
        };
        t1.start();
        t2.start();
        System.out.println("=======================");
    }
}
