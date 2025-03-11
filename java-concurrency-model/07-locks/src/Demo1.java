import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo1 {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(Demo1::method1, "t1").start();
        new Thread(Demo1::method1, "t2").start();
        new Thread(Demo1::method1, "t3").start();
    }
    public static void method1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " +
                        "method1");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
        finally{
            lock.unlock();
        }
    }
}
