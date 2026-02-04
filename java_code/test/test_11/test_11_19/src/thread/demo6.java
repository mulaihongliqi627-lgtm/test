package thread;

public class demo6 {
    static Object lockerA = new Object();
    static Object lockerB = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           synchronized (lockerA){
               try {
                   Thread.sleep(1000);//使得线程t2有足够时间拿到锁B
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized (lockerB){
                   System.out.println("hello cheems");
               }
           }
        });
        Thread t2 = new Thread(()->{
            synchronized (lockerB){
                try {
                    Thread.sleep(1000);//使得线程t1有足够时间拿到锁A
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockerA){
                    System.out.println("hello doge");
                }
            }
        });
        t1.start();
        t2.start();

    }
}
