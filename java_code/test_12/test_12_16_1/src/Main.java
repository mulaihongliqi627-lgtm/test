import java.util.concurrent.locks.ReentrantLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Object locker = new Object();
    private static ReentrantLock locker2 = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (locker){
                synchronized (locker){
                    System.out.println("hello t1");
                }
            }
        });
        Thread t2 = new Thread(()->{
            locker2.lock();
            try{
                locker2.lock();
                try{
                    System.out.println("hello t2");
                }finally {
                    locker2.unlock();
                }
            }finally {
                locker2.unlock();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("hello main");
    }
}