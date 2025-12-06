package threadPool;

import java.util.concurrent.*;

public class MyThreadFactory implements ThreadFactory {
    //重写newThread方法，自定义创建的线程
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"线程-1");//命名
        t.setDaemon(false);//设置为前台线程
        System.out.println(t.getName() + "已创建");
        return t;
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(20);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cheems");
            }
        };
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,
                20,
                20L,
                TimeUnit.MILLISECONDS,
                workQueue,
                new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        pool.submit(task);
    }
}
