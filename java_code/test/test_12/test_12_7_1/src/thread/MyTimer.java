package thread;

import java.util.PriorityQueue;

class  MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable task;
    private long time;

    public MyTimerTask(Runnable task, long delay) {
        this.task = task;
        this.time = System.currentTimeMillis() + delay;//任务的执行时间
    }
    public long getTime(){
        return time;
    }
    public void run(){
        task.run();//启动TimerTask的线程
    }
    //设置比较规则


    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }
}

public class MyTimer {
    private Object locker = new Object();
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public MyTimer(){
        Thread t = new Thread(()->{
            try {
                while (true){
                    synchronized (locker){//避免
                        while (queue.isEmpty()){//队列无任务,等待queue添加任务
                            locker.wait();//等queue添加任务时再被唤醒
                        }
                        //有任务时，判断队列头的任务是否到达可执行的时间
                        MyTimerTask task = queue.peek();
                        long curTime = System.currentTimeMillis();
                        if(task.getTime() > curTime){//任务没到执行时间
                            locker.wait(task.getTime() - curTime);//wait 等到了再执行
                        }else{
                            queue.poll();//任务弹出
                            task.run();//执行出队列任务
                        }
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t.start();
    }
    //提交任务到优先级队列
    public void schedule(Runnable task,long delay){//向队列中添加任务
        synchronized (locker){
            queue.offer(new MyTimerTask(task,delay));
            locker.notify();//唤醒之前空队列时，Timer内置前台线程试图执行任务时引发的阻塞
        }
    }


    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        },4000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        },1000);
        System.out.println("hello main");
    }
}
