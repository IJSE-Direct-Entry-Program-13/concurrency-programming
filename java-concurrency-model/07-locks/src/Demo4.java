import java.util.concurrent.locks.ReentrantLock;

public class Demo4 {
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(Demo4::method1, "t1").start();
        new Thread(Demo4::method2, "t2").start();
    }
    static void method1(){
        try {
            System.out.println("method1: " +
                    Thread.currentThread().getName() + ": " +
                    lock.isLocked());
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": method1");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
        finally {
            lock.unlock();
        }
    }
    static void method2(){
        try {
            Thread.sleep(100);
            System.out.println("method2: " +
                    Thread.currentThread().getName() + ": " +
                    lock.isLocked());
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": method2");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
        finally {
            lock.unlock();
        }
    }
}
