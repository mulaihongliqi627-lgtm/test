package thread;

public class demo8 {
    private static Object locker = new Object();
    private static Object locker2 = new Object();
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            synchronized (locker){
                System.out.println("wait等待之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("a线程wait等待结束了");
            }
        });
        Thread b = new Thread(()->{
            synchronized (locker){
                locker.notify();
                System.out.println("随机唤醒一个wait等待线程");
            }
        });
//        Thread c = new Thread(()->{
//            synchronized (locker){
//                try {
//                    locker.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("c线程wait阻塞了");
//            }
//        });
        a.start();
        b.start();
//        c.start();

    }
}
