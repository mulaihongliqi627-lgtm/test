public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue2 myBlockingQueue = new MyBlockingQueue2(5);
        myBlockingQueue.put("1");
        myBlockingQueue.put("2");
        myBlockingQueue.put("3");
        myBlockingQueue.put("4");
        myBlockingQueue.put("5");
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
        System.out.println(myBlockingQueue.take());
    }
}