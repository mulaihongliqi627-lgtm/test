package thread;

public class demo7 {
    static volatile int n  =0;
    public static int func(){
        return n++;
    }
    public static void main(String[] args) {
        System.out.println(func());
        System.out.println("n = "+ n);
    }
}
