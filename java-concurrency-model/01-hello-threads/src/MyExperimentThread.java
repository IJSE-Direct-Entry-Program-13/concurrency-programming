public class MyExperimentThread {
    public static void main(String[] args) {
        new MyCrazyThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am from Runnable");
            }
        }).start();
    }
}
class MyCrazyThread extends Thread {
    public MyCrazyThread(Runnable task) {
        super(task);
    }
    @Override
    public void run() {
        System.out.println("I am from My Crazy Thread");
        super.run();
    }
}
