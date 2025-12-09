package thread;

import java.util.PriorityQueue;
public class MyTimer {
    private Object locker = new Object();
    PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    public MyTimer(){
        Thread t = new Thread(()->{
            while (true){
                try {
                    synchronized (locker){
                        if(queue.isEmpty()){//队列为空，尝试执行会wait
                            locker.wait();
                            continue;
                        }
                        //队列不为空时，看看队首任务是否到达执行时间
                        MyTimerTask curTask = queue.peek();
                        long curTime = System.currentTimeMillis();//查看当前时间
                        if(curTask.getTime()  > curTime){//时间未到
                            locker.wait(curTask.getTime() - curTime);//阻塞到任务时间到再执行
                        }else {
                            queue.poll().run();//到达了执行时间，弹出队首元素并执行
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();//启动线程
    };
    public void schedule(Runnable task,long time){
        synchronized (locker){
            queue.offer(new MyTimerTask(task,time));
            locker.notify();//此处的唤醒操作是唤醒队列为空时t线程内while循环产生的阻塞
        }
    }
}
