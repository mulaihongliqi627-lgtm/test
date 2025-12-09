package thread;

public class MyTimerTask implements Comparable<MyTimerTask>{
    private long time;
    private Runnable runnable;

    public MyTimerTask(Runnable runnable,long time){//构造方法
        this.runnable = runnable;
        this.time = time + System.currentTimeMillis();//任务执行的时刻 = 延迟时间 + 当前时刻
    }
    public long getTime(){//方便类外获取到MyTimer的执行时刻
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {//定义比较规则，先执行的任务排前面
        return (int)(this.time - o.time);
    }
    public void run(){//启动任务
        runnable.run();
    }
}
