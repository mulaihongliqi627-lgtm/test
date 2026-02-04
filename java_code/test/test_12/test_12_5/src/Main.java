import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main1(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(10);//阻塞队列
        ExecutorService pool =  Executors.newFixedThreadPool(10);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cheems");
            }
        });
        List<String> list = new LinkedList<>();
        String s = "111";
        System.out.println(s + "s");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        String s = sc.next();
        char[]arr = s.toCharArray();
        int x = 1;
        while (x < n) x *= 2;
        t %= x;
        while (t > 0){
            for(int i = n-1;i >= 1;i--){
                int num = (arr[i]- '0') ^ (arr[i-1] - '0');
                arr[i] = (char) (num + '0');
            }
            t--;
        }
        String str = new String(arr);
        System.out.println(str);
    }

}