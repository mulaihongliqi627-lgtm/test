package thread;

public class demo2 {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        //count自增 10w 次
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 100000;i++){
                count++;
            }
        });
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);//让t2线程休眠1s，等待t1线程线执行结束
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0;i < 100000;i++){
                count++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
