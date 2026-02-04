package thread;

//自定义线程
class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

public class demo1 {
    public static void main(String[] args)  {
        //使用自定义线程
        MyThread myThread = new MyThread();
        myThread.start();
        while(true){
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
