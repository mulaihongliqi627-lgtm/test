package demo;

public class Demo1 {
    public static void main1(String[] args) throws InterruptedException {
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
