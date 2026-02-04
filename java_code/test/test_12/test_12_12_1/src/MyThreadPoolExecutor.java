import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExecutor {
    private BlockingQueue<Runnable>queue = new LinkedBlockingQueue<>();
    public void submit(Runnable runnable) throws InterruptedException {//提交任务
        queue.offer(runnable);
    }
    public MyThreadPoolExecutor(int nThread){//创建n个线程的线程池
        for(int i = 0;i < nThread;i++){

            Thread t = new Thread(()->{
                try{
                    while (true){
                        Runnable task = queue.take();
                        task.run();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}

