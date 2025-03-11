import java.util.concurrent.locks.ReentrantLock;

public class Demo5 {
    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(Demo5::execute, "t1").start();
        new Thread(Demo5::execute, "t2").start();
        new Thread(Demo5::execute, "t3").start();
    }

    public static void execute() {
        System.out.println(Thread.currentThread().getName() + " athulata aawo");
        try {
            while (!lock.tryLock()){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() +
                        ": Mata lock eka ne... lock ekak diyaw!");
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": executing");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }
}
