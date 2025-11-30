public class MyBlockingQueue {
    private String[]arr = null;
    private int size = 0;
    private int head;
    private int tail;
    private Object locker = new Object();
    //构造方法
    public MyBlockingQueue(int capacity){
        arr = new String[capacity];
    }
    //向阻塞队列添加元素
    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            if(size == arr.length){//队列满了，尝试添加会阻塞
                System.out.println("尝试添加" + elem + "时队列已满");
                locker.wait();
            }
            arr[tail++] = elem;
            if(tail >= arr.length){//越界
                tail = 0;
            }
            size++;
            locker.notify();//唤醒队列为空时，take的阻塞
        }
    }
    //从阻塞队列拿取元素，队头拿取
    public String take() throws InterruptedException {
        synchronized (locker){
            if(size == 0){//没有元素可以take
                System.out.println("队列为空，没有元素可拿");
                locker.wait();
            }
            String str = arr[head++];
            if(head >= arr.length){
                head = 0;
            }
            size--;
            locker.notify();
            return str;
        }
    }
}
