public class Demo1 {

    public static void main(String[] args) {
        Runnable task = () -> {
            executeMe();
        };
        new Thread(task, "t1").start();
        executeMe();
    }

    public synchronized static void executeMe() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " +
                    "Hello");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
