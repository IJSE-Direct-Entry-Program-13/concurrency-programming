package deadlock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                B.method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
        Thread.sleep(1);
        new Thread(A::method1, "t1").start();
    }
}
class A{
    static synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + ": entered into A:method1");
        B.method2();
        System.out.println(Thread.currentThread().getName() + ": exited from A:method1");
    }
    static synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + ": entered into A:method2");
        System.out.println(Thread.currentThread().getName() + ": exited from A:method2");
    }
}
class B{
    static synchronized void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": entered into B:method1");
        Thread.sleep(100);
        A.method2();
        System.out.println(Thread.currentThread().getName() + ": exited from B:method1");
    }
    static synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + ": entered into B:method2");
        System.out.println(Thread.currentThread().getName() + ": exited from B:method2");
    }
}