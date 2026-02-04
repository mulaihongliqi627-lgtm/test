import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            locker.lock();//加锁
            try {
                System.out.println("hello cheems");
            }finally {//解锁unlock操作必须定义在finally代码块中
                locker.unlock();//解锁
            }
        });
        t.start();
        Thread.sleep(1000);
        System.out.println("hello main");
    }

}