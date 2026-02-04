package thread;

import java.util.Scanner;

public class demo4 {
    static volatile boolean flag = true;//使用volatile修饰变量
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (flag){

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
