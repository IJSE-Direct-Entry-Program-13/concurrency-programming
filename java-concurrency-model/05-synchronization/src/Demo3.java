public class Demo3 {
    private static int x = 10;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();
        Thread.sleep(10);
        new Thread(() -> {change();}, "t2").start();
    }

    public synchronized static void change(){
        x = 5;
    }

    public synchronized static void update() throws InterruptedException {
        System.out.println(x);
        x = 20;
        Thread.sleep(20);
        System.out.println(x);
    }
}


