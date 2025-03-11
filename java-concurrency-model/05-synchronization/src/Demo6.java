public class Demo6 {
    static Customer c1 = new Customer();
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                c1.sayHello();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
        new Thread(() -> {
            try {
                method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t3").start();
    }
    static void method1() throws InterruptedException {
        synchronized (c1) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": I am method1");
                Thread.sleep(100);
            }
        }
    }
    synchronized static void method2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +
                    ": I am method2");
            Thread.sleep(100);
        }
    }
}
class Customer{
    synchronized void sayHello() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +
                    ": I am from customer class");
            Thread.sleep(100);
        }
    }
}