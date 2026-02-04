package thread;

import java.util.Scanner;

public class demo3 {
    static Object locker = new Object();
    static boolean flag = true;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (flag){
                synchronized (locker){//加锁

                }
            }
            System.out.println("t1线程结束了");
        });
        t1.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入任意内容，结束线程t1");
        sc.next();
        flag = false;
        System.out.println("flag = " + flag);
    }
}
