package thread;

public class demo2 {

    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println("have a good night");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);//把实现了Runnable接口的myRunnable实例作为Thread参数
        t.start();
        while (true){
            System.out.println("cheems");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
