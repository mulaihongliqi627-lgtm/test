import java.util.concurrent.Semaphore;

public class Demo4 {
    private  static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               try{
                   //尝试对count自增前先获取资源,获取不到就阻塞，
                   //等其他线程release释放资源才能count++，使得count++变为原子性 线程安全
                   semaphore.acquire();
                   count++;
                   semaphore.release();//释放资源，使得其他线程可以获取资源
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });
        Thread t2 = new Thread(()->{
           for (int i = 0;i < 50000;i++){
               try{
                   semaphore.acquire();
                   count++;
                   semaphore.release();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
