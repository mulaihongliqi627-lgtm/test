package threadPool;

import java.util.concurrent.*;

public class Demo2 {
    public static void main(String[] args) {
        //通过newFixedThreadPool方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cheems");
            }
        };
        //提交任务
        //pool.submit(task);
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        ExecutorService pool3 = Executors.newScheduledThreadPool(10);
        pool1.submit(task);
        //ThreadPoolExecutor pool4 = new ThreadPoolExecutor(10,)
        BlockingQueue queue = new ArrayBlockingQueue(20);//工作队列容量为20
        ThreadPoolExecutor pool5 = new ThreadPoolExecutor(10,20,
                30L,TimeUnit.MILLISECONDS,queue);
        pool5.submit(task);

    }
}
