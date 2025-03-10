public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("I am the task");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()
                    + " is about to exit");
        };
        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        t2.start();
        t1.setName("t1");
        t1.start();
        System.out.println("main: I am about to die");
        //while (t1.isAlive() || t2.isAlive()) Thread.onSpinWait();
        t1.join();
        t2.join();
        System.out.println("main: Let's die together");
    }
}
