import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {

    static AtomicInteger x = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Demo2::change, "t1");
        Thread t2 = new Thread(Demo2::change, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x.get());
    }

    static void change(){
        // x.incrementAndGet();
        //x.addAndGet(1);

        int newValue = x.get() + 1;
        while(!x.compareAndSet(x.get(), newValue))
            System.out.println("Trying");
    }

}
