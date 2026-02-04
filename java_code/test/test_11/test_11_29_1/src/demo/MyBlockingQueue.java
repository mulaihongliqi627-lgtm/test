package demo;

public class MyBlockingQueue {
    private String[]arr = null;
    private int size = 0;
    private int head = 0;//头索引
    private int tail = 0;//尾索引
    private static Object locker = new Object();
    public MyBlockingQueue(int capacity){//构造方法，初始容量
        arr = new String[capacity];
    }
    //向队列尾添加元素
    public void put(String key) throws InterruptedException {
        synchronized (locker){
            if(size == arr.length){
                locker.wait();//队列满，产生阻塞
            }
            arr[tail++] = key;
            if(tail >= arr.length){//下标越界
                tail = 0;
            }
            size++;
            locker.notify();//唤醒阻塞的线程
        }
    }
    public String take() throws InterruptedException {
        synchronized (locker){
            if(size == 0){//队列为空，没有元素可以拿
                locker.wait();
            }
            String str = arr[head++];
            if(head >= arr.length){//下标越界
                head = 0;
            }
            size--;
            locker.notify();
            return str;
        }
    }
    //判空
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue(3);
        queue.put("111");
        queue.put("222");
        queue.put("333");
        System.out.println("队列内元素总个数为: " + queue.getSize());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println("队列内元素总个数为: " + queue.getSize());
    }
}
