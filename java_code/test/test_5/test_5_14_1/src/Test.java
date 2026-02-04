import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Random random=new Random();
        int num= random.nextInt(100);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("请输入你猜的数字：");
            int guess=sc.nextInt();
            if(guess>num){
                System.out.println("猜大了");
            }
            else if(guess==num){
                System.out.println("猜对了");
                break;
            }
            else if(guess<num){
                System.out.println("猜小了");
            }
        }

    }

}
