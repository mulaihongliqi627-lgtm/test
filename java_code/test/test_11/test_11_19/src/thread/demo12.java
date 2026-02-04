package thread;

public class demo12 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();
    private static Object locker3 = new Object();
    private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker1){
                        locker1.wait();
                    }
                    System.out.print("晚");
                    synchronized (locker2){
                        locker2.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker2){
                        locker2.wait();
                    }
                    System.out.print("安");
                    synchronized (locker3){
                        locker3.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker3){
                        locker3.wait();
                    }
                    System.out.println("cheems");
                    synchronized (locker1){
                        locker1.notify();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);//先休眠，保证三个线程都陷入wait等待
        synchronized (locker1){//从线程t1开始唤醒
            locker1.notify();
        }
    }
}
