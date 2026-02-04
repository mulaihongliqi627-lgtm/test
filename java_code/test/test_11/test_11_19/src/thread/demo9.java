package thread;

public class demo9 {
    private static Object locker = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("t1线程wait了");
           synchronized (locker){
               try {
                   locker.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           System.out.println("t1线程被唤醒了");
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2线程wait了");
           synchronized (locker){
               try {
                   locker.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           System.out.println("t2线程被唤醒了");
        });
        Thread t3 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (locker){
                System.out.println("t3线程随机唤醒一个wait状态的等待线程");
                locker.notify();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
