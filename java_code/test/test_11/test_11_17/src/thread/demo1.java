package thread;

public class demo1 {
    static int count = 0;
    static int sum1 =0,sum2 = 0;
    public static void main(String[] args) throws InterruptedException {
        //count自增 10w 次
        Thread t1 = new Thread(()->{
            int x = 0;
           for(int i = 0;i < 100000;i++){
               x++;
           }
           sum1 = x;
        });
        Thread t2 = new Thread(()->{
            int y = 0;
           for(int i = 0;i < 100000;i++){
               y++;
           }
           sum2 = y;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sum1 + sum2);
    }
}
