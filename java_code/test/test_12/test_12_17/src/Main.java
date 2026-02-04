import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static AtomicInteger count = new AtomicInteger(0);
    private static int val = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               val++;
           }
        });
        Thread t2 = new Thread(()->{
           for(int i = 0;i < 50000;i++){
               val++;
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(val);
    }
}