package thread;

import java.util.Random;

public class demo2 {
    public static int []arr = new int[10000000];
    public static long time1 = 0;
    public static long time2 = 0;
    static long sum1 = 0;
    static long sum2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        //线程1 计算偶数下标元素的和,
        Thread t1 = new Thread(()->{
            long x1 = System.currentTimeMillis();
            for (int i = 0;i < 10000000;i+=2){
                sum1 += arr[i];
            }
           long x2 = System.currentTimeMillis();
           //计算运算时间
           time1  = x2 - x1;
        });

        //线程2计算奇数下标元素的和.
        Thread t2 = new Thread(()->{
            long y1 = System.currentTimeMillis();
            for (int i = 1;i < 10000000;i+=2){
                sum2 += arr[i];
            }
            long y2 = System.currentTimeMillis();
            //计算运算时间
            time2  = y2 - y1;
        });
        //初始化数组
        for(int i = 0;i < arr.length;i++){
            arr[i] = random.nextInt(101);//生成1-100之间的随机数
        }
        t1.start();
        t2.start();
        //让main线程等待两个创建的线程
        t1.join();
        t2.join();
        System.out.println("数组总和为" + sum1 + sum2);
        System.out.println("线程1的运算时间为" + time1);
        System.out.println("线程2的运算时间为" + time2);
    }
}
