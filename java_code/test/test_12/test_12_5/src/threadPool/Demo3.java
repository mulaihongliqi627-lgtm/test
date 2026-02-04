package threadPool;

import java.util.concurrent.*;

public class Demo3 {
    public static void main(String[] args) {
        //创建任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cheems");
            }
        };
        //创建工作队列
        BlockingQueue workQueue = new ArrayBlockingQueue(20);//工作队列容量为20

        //创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20,
                10L, TimeUnit.MILLISECONDS, workQueue, new ThreadPoolExecutor.AbortPolicy());
        //提交任务
        pool.submit(task);
    }
}
