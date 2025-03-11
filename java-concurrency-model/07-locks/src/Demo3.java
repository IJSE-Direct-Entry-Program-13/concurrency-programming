public class Demo3 {

    public static void main(String[] args) {
        new Thread(Demo3::method1, "t1").start();
        new Thread(Demo3::method2, "t2").start();
    }
    synchronized static void method1(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": method1");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
    }
    synchronized static void method2(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": method2");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
    }
}
