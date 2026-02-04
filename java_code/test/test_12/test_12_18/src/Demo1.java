public class Demo1 {
    public static class Result{
        private int sum = 0;
        private Object locker = new Object();
    }
    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();//创建result实例
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for(int i = 1;i <= 100;i++){
                    sum += i;
                }
                synchronized (result.locker){
                    result.sum = sum;//把返回值传给中间件result的sum
                    result.locker.notify();//唤醒main线程在未等到t1线完成累加操作引发的阻塞
                }
            }
        };
        t1.start();
//        t1.join();
//        System.out.println(result.sum);
        synchronized (result.locker){
            while (result.sum == 0){//t1线程还没完成累加操作，重复阻塞
                result.locker.wait();
            }
            System.out.println(result.sum);
        }
    }
}
