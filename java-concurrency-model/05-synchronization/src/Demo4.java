import java.time.Duration;

public class Demo4 {
    volatile static int x = 10;
    public static void main(String[] args) {
        new Thread(Demo4::calc).start();
        new Thread(Demo4::change).start();
    }
    public synchronized static void change(){
        x = 5;
        System.out.println("x changed to " + x);
    }
    public static void calc(){
        System.out.println("Entering into the change()");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Before the calculation");
        synchronized (Demo4.class) {
            System.out.println("x=" + x);
            x += x * 2;
            System.out.println("After the calculation");
            System.out.println("x=" + x);
        }
        System.out.println("Exiting from the change()");
    }
}
