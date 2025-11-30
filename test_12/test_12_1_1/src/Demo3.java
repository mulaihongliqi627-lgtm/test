import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();
        long week = 5 * a + 2 * b;//一周的做题量
        long days = 7 * (n / week);
        long x = n % week;//剩余的题不到一周即可完成
        if(5 * a > x){//前五天可以完成
            if((1.0 * x)/a > x/a){
                days += x/a + 1;
            }else{
                days += x/a;
            }
        }else{//周末也要写
            days += 5;
            x = x - 5 * a;
            if((1.0 * x)/b > x/b){
                days += x/b + 1;
            }else{
                days += x/b;
            }
        }
        System.out.println(days);
    }
}
