import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

//使用CountDownLatch来模拟跑步比赛
public class Demo1 {
    private static AtomicInteger count = new AtomicInteger(0);//院子类
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    //线程sleep模拟跑步每一个线程跑步耗时
                    long startTime = System.currentTimeMillis();//起跑时间
                    Thread.sleep((long) (Math.random() * 10000));
                    long endTime = System.currentTimeMillis();
                    long costTime = endTime - startTime;//计算跑步所需要的时间
                    System.out.println("线程" + count.incrementAndGet() + "跑完" + "共耗时：" + costTime+"豪秒");
                    latch.countDown();//标记已经跑完的人数+1
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        System.out.println("起跑！");
        for(int i = 0;i < 10;i++){
            Thread t = new Thread(runnable);
            t.start();
        }
        latch.await();//十个人全部跑完才宣布比赛结束，执行await之后的逻辑
        System.out.println("比赛结束");
    }
}
