package thread;

import java.util.Scanner;

public class demo1 {
    static boolean flag = true;//定义一个成员变量标识符
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1);//留给main线程操作时间
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(flag){
                while (true){

                }
            }
            System.out.println("线程t1已结束");
        });
        t1.start();
        System.out.println("输入任意内容，结束线程t1");
        Scanner sc = new Scanner(System.in);
        sc.next();
        flag = false;
        System.out.println("flag = " + flag);
    }
}
