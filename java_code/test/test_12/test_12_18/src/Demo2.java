import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//callable也是一个类似于Runnable的接口，可在call方法内部定义任务逻辑，区别是callable有返回值，但是runnable没有
//callable的返回值通过FutureTask的get方法获取
public class Demo2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = new Callable<Integer>() {//匿名内部类搭配接口使用，call返回值是什么类型。泛型就是什么类型
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 1;i <= 1000;i++){
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> task = new FutureTask<>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        t1.join();
        System.out.println(task.get());//获取callable的返回值，并打印
    }
}
