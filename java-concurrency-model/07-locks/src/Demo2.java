public class Demo2 {

    public static void main(String[] args) {
        new Thread(Demo2::method1, "t1").start();
        new Thread(Demo2::method1, "t2").start();
        new Thread(Demo2::method1, "t3").start();
    }

    public synchronized static void method1() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " +
                        "method1");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}
