import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPoolExecutor pool = new MyThreadPoolExecutor(10);

        for(int i = 0;i < 100;i++){
            int id = i;//使用id变量捕获，如果使用i，就会导致main线程i遍历过快，线程池内现场执行访问的i变化过快无法正确访问
            pool.submit(()->{
                System.out.println("第" + id + "个任务:" + Thread.currentThread().getName());
            });
        }
    }
}