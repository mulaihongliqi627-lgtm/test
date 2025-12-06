package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(10);//阻塞队列

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cheems");
            }
        };
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,10,
                10,TimeUnit.MILLISECONDS,blockingQueue);//创建线程池
        pool.submit(task);//提交任务

    }
}
