package thread;

import java.util.Scanner;

public class demo1 {
    private static boolean running = true;
    public static void main(String[] args) {

        Thread t = new Thread(()->{
           while (!Thread.currentThread().isInterrupted()){//当前线程状态
               System.out.println("hello cheems");
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
            System.out.println("线程结束了");
        });
        t.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入任意内容,线程结束");
        sc.next();
        running = false;
    }
}

