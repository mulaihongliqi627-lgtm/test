package org.example;

public class Main {
    private static Object lockerA = new Object();
    private static Object lockerB = new Object();
    private static Object lockerC = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (lockerA){
                try {
                    lockerA.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1线程被唤醒");
        });
        Thread t2 = new Thread(()->{
           synchronized (lockerA){
               try {
                   lockerB.wait();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
            System.out.println("t2线程被唤醒");
        });
        Thread t3 = new Thread(()->{
            synchronized (lockerA){
                lockerA.notifyAll();//唤醒全部阻塞线程
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
    }
}