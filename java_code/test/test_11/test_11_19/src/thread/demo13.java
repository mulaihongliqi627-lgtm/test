package thread;

public class demo13 {
    private static Object lockerA = new Object();
    private static Object lockerB = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (lockerA){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockerB){
                    System.out.println("t1线程启动");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (lockerB){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockerA){
                   System.out.println("t2线程启动");
               }
           }
        });
        t1.start();
        t2.start();
    }
}
