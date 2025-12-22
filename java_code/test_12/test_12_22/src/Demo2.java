import java.util.concurrent.Semaphore;

//Semaphore模拟锁实现
public class Demo2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("获取资源");
                    semaphore.release();
                    System.out.println("释放资源");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        for(int i = 0;i < 10;i++){
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
