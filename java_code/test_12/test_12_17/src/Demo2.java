import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               count.incrementAndGet();
           }
        });
        Thread t2 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               count.incrementAndGet();
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
