package thread;

public class Demo1 {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello cheems");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        Thread.sleep(200);
        System.out.println("hello main");
    }
}
