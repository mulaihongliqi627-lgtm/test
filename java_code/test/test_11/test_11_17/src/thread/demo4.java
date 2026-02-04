package thread;

public class demo4 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        //count自增100次
        Thread t1 = new Thread(()->{
            for(int i = 0;i < 100;i++){
                count++;
            }
        });
        Thread t2 = new Thread(()->{
           for(int i = 0;i < 100;i++){
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
