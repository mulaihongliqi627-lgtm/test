import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i <= n;i++){
            if(check(i)) count++;
        }
        System.out.println(count);
    }
    //检查一个数是否是好数
    public static boolean check(int x){
        int cnt = 0;//初始为1位
        while (x > 0){
            cnt++;
            int num = x % 10;
            if((cnt % 2 != 0 && num % 2 != 0) || (cnt % 2 == 0 && num % 2 == 0)){//奇数位是奇数,偶数位是偶数
                x /= 10;
                continue;
            }else return false;
        }
        return true;
    }

}