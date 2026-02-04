package demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        queue.add("111");
        queue.add("222");
        queue.add("333");
        queue.add("444");
        queue.add("555");
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        System.out.println("队列为空");
    }
}
