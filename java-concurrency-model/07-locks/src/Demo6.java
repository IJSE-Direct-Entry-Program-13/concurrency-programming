import java.util.concurrent.locks.ReentrantLock;

public class Demo6 {
    static ReentrantLock rl = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Customer c = new Customer();
        new Thread(Demo6::method1, "t1").start();
        Thread.sleep(100);
        new Thread(Demo6::method2, "t2").start();
        new Thread(c::method3, "t3").start();
    }
    static void execute(String name){
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + name);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
    }
    static void method1(){
        rl.lock();
        execute("method1");
        rl.unlock();
    }
    static void method2(){
        rl.lock();
        execute("method2");
        rl.unlock();
    }
}
class Customer{
    void method3(){
        Demo6.rl.lock();
        Demo6.execute("method3");
        Demo6.rl.unlock();
    }
}

