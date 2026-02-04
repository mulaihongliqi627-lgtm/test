public class Demo1 {
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (locker){
                System.out.println("hello t1");
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (locker){
                System.out.println("hello t2");
            }
        });
        Thread t3 = new Thread(()->{
            synchronized (locker){
                System.out.println("hello t3");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println("hello main");
    }
}
