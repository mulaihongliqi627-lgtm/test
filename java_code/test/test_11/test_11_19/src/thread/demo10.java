package thread;

public class demo10 {
     private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (object){
                System.out.println("t1线程陷入wait等待了");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);取消抛异常，让代码继续往下执行
                    System.out.println("t1线程wait中断了");
                }
                System.out.println("t1线程结束wait等待了");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
