package thread;

public class Demo1 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();
    private static Object locker3 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker1){
                        locker1.wait();
                    }
                    System.out.print("A" + " ");
                    synchronized (locker2){
                        locker2.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker2){
                        locker2.wait();
                    }
                    System.out.print("B" + " ");
                    synchronized (locker3){
                        locker3.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker3){
                        locker3.wait();
                    }
                    System.out.println("C" + " ");
                    synchronized (locker1){
                        locker1.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(500);//让t线程后执行
        //此时三个线程都陷入wait等待
        Thread t = new Thread(()->{
            synchronized (locker1){
                locker1.notify();//从t1线程开始唤醒
            }
        });
        t.start();
    }
}
