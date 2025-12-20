import javax.management.ObjectName;
import java.util.Scanner;

public class Demo1 {
    private static Object locker = new Object();
    private static int state = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           try {
               for(int i = 0;i < 10;i++){
                   synchronized (locker){
                       while (state % 3 != 0){//没有轮到该线程打印，wait
                           locker.wait();
                       }
                       System.out.print("A" + " ");//轮到了，打印
                       state++; //状态码++
                       locker.notifyAll();
                   }
               }
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        });
        Thread t2 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker){
                        while (state % 3 != 1){//没有轮到该线程打印，wait
                            locker.wait();
                        }
                        System.out.print("B" + " ");//轮到了，打印
                        state++; //状态码++
                        locker.notifyAll();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                for(int i = 0;i < 10;i++){
                    synchronized (locker){
                        while (state % 3 != 2){//没有轮到该线程打印，wait
                            locker.wait();
                        }
                        System.out.println("C");//轮到了，打印
                        state++; //状态码++
                        locker.notifyAll();
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Scanner sc = new Scanner(System.in);
        System.out.print("输入任意内容，启动线程: ");
        sc.next();
        t1.start();
        t2.start();
        t3.start();
    }
}
