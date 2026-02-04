import java.util.Scanner;

public class Test {
    public static boolean perfectNumber(int num) {
        int total_num = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                total_num += i;
            }
        }
        if (total_num == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int peach=1;
        for(int i=10;i>1;i--){
            peach=2*peach+2;
        }
        System.out.println("第一天摘了"+peach+"个桃子");
    }

    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        if(perfectNumber(num)){
            System.out.println(num+"是完全数");
        }else {
            System.out.println(num+"不是完全数");
        }
    }

}
