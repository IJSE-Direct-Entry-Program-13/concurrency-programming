public class Demo5 {
    static int x = 10;

    public static void main(String[] args) {
        new Thread(Demo5::calc).start();
        new Thread(Demo5::calc).start();
    }

    public static void calc() {
        System.out.println("Entering into the change()");
        System.out.println(Thread.currentThread().getName());
        synchronized (String.class) {
            x++;
            x = x + 10;
            System.out.println(x);
        }
    }
}
