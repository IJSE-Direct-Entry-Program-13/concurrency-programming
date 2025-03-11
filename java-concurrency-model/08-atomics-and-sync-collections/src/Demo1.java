public class Demo1 {

    static int x = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Demo1::change, "t1");
        Thread t2 = new Thread(Demo1::change, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(x);
    }

    static void change(){
        x++;
    }

}
