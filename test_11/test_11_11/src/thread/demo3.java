package thread;

public class demo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread []thread = new Thread[20];
        for(int i= 0;i < 20;i++){
            final int n = i;
            thread[i] = new Thread(()->{
                System.out.println(n);
            });
        }
        //启动线程
        for(Thread t : thread){
            t.start();
        }
        //让main线程等待线程输出完
        for(Thread t : thread){
            t.join();
        }
        System.out.println("OK");
    }
}
