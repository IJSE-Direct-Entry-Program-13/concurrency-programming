public class NamedThread {

    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am from a new thread");
    }
}
