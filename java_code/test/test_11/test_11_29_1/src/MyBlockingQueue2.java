public class MyBlockingQueue2 {
    private String []arr = null;
    private int head;
    private int tail;
    private Object locker = new Object();
    private int size = 0;
    public MyBlockingQueue2(int capacity){
        arr = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            if(size == arr.length){
                System.out.println("尝试添加" + elem + "时队列已满");
                locker.wait();
            }
            arr[tail++] = elem;
            if(tail >= arr.length){
                tail = 0;
            }
            size++;
            locker.notify();
        }
    }
    public String take() throws InterruptedException {
        synchronized (locker){
            if(size == 0){
                System.out.println("队列为空，没有元素可拿");
                locker.wait();
            }
            String ret = arr[head++];
            if(head >= arr.length){
                head = 0;
            }
            size--;
            locker.notify();
            return ret;
        }
    }
}
