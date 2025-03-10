public class Demo1 {

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am task bro");
            System.out.println("===================");
        };
        Thread t1 = new Thread(task);
//        t1.setDaemon(true);
        t1.start();
        System.out.println("main: I am the gangster here");
        System.out.println("main: But I am about to experience the death");
    }
}
