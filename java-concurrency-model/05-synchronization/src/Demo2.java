public class Demo2 {

    public static void main(String[] args) {
        Runnable task = () -> {
            executeMethod1();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executeMethod2();
        };
        new Thread(task, "t1").start();
        executeMethod2();
    }

    public synchronized static void executeMethod1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " +
                    "Method1");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized static void executeMethod2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " +
                    "Method2");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
