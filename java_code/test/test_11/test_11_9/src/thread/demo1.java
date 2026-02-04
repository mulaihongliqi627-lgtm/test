package thread;

import com.sun.security.jgss.GSSUtil;

public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        //创建线程，默认为前台线程
        Thread t = new Thread(()->{
            while (true){
                System.out.println("hello cheems");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(t.getId());//获取线程id
        System.out.println(t.getName());//获取线程名字
        System.out.println(t.getState());//获取线程状态
        System.out.println(t.getPriority());//获取线程优先级
        System.out.println("是否是后台线程" + t.isDaemon());//是否是后台线程
        t.start();
        System.out.println(t.isAlive());//查看线程是否存活，只有启动线程后才为true
        t.interrupt();
        System.out.println("线程是否存活" + t.isAlive());//查看线程是否存活，中断线程不会结束run()
        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
