package thread;

public class demo5 {
    static  int count = 0;
    static Object lockerA = new Object();
    static Object lockerB = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (lockerA){
                for(int i = 0;i < 100000;i++){
                    count++;
                }
            }
        });
        Thread t2 = new Thread(()->{
           synchronized (lockerB){//分配不同的锁，不会产生锁竞争
               for (int i = 0;i < 100000;i++){
                   count ++;
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
