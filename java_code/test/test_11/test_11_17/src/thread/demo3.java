package thread;

public class demo3 {

    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread t1 = new Thread(()->{
            synchronized (lockA){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB){
                   System.out.println("hello cheems");
               }
           }
        });
        Thread t2 = new Thread(()->{
            synchronized (lockB){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA){
                    System.out.println("hello doge");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("线程结束");
    }
}
