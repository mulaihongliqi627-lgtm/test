package thread;

public class demo11 {
    private static int n = 10;
    private static Object object = new Object();
    public static void main(String[] args) {
        for(int i = 0;i < n;i++){
            Thread t1 = new Thread(()->{
                synchronized (object){
                    System.out.print("A");
                }
            });
            Thread t2 = new Thread(()->{
                synchronized (object){
                    try {
                        object.wait(1000);
                    } catch (InterruptedException e) {
                        System.out.println("线程t2等待中");
                    }
                }
                System.out.print("B");
            });
            Thread t3 = new Thread(()->{
                synchronized (object){
                    try {
                        object.wait(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("C");
            });
            t1.start();
            t2.start();
            t3.start();
        }

    }
}
