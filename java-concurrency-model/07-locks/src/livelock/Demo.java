package livelock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    static ReentrantLock rl1 = new ReentrantLock();
    static ReentrantLock rl2 = new ReentrantLock();
    static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();
        Thread.sleep(1);
        new Thread(() -> {
            try {
                method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
        Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(() -> flag = !flag, 0, 1, TimeUnit.NANOSECONDS);
    }
    static boolean method1() throws InterruptedException {
        execute("Entering into method1");
        if (!rl1.tryLock()) {
            execute("Lock failed");
            return false;
        }
        execute("method1");
        while (flag){
            if (method2()) break;
        }
        rl1.unlock();
        execute("Exiting from method1");
        return true;
    }
    static boolean method2() throws InterruptedException {
        execute("Entering into method2");
        if (!rl2.tryLock()) {
            execute("Lock failed");
            return false;
        }
        execute("method2");
        while (!flag) {
            if (method1()) break;
        }
        rl2.unlock();
        execute("Exiting from method2");
        return true;
    }
    static void execute(String desc){
        System.out.println(Thread.currentThread().getName() + ": " + desc);
    }
}

