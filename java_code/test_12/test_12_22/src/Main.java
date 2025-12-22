import java.util.concurrent.Semaphore;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        //定义线程执行任务逻辑
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("获取资源");
                    semaphore.acquire();
                    Thread.sleep(1000);//休眠一秒
                    System.out.println("释放资源");
                    semaphore.release();//释放资源
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        for(int i = 0;i < 20;i++){
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}