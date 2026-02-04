package thread;

public class demo5 {
    public static void main(String[] args) throws InterruptedException {
        //使用lamdba表达式作为参数传给Thread构造方法
        Thread t = new Thread(()->{
            while (true) {
                System.out.println("hello cheems");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
