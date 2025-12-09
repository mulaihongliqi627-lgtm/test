import thread.MyTimer;
import thread.MyTimerTask;

public class Main {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 4");
            }
        },4000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        },3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        },2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        },1000);
    }
}