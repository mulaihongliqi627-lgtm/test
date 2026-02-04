import java.util.concurrent.Semaphore;

//线程不安全版本count自增
public class Demo3 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               count++;
           }
        });
        Thread t2 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               count++;
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
