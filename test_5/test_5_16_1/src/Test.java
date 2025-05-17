import java.util.Scanner;

public class Test {
    public static int fib(int n) {//求第n个斐波那契数
        if(n==1||n==2){
            return 1;
        }
        int f1=1;
        int f2=1;
        int f3=-1;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(10));
        System.out.println(fib(15));
    }



    public static int totalSum(int n){//计算各个位数数字之和
        if(n<10){
            return n;
        }else{
            return n%10+totalSum(n/10);
        }
    }

    public static void main5(String[] args) {
        int n=1345;
        System.out.println(totalSum(n));
    }

    public static int sum(int n){//求和方法
        if(n==1)
            return 1;
        else{
            return n+sum(n-1);
        }
    }

    public static void main4(String[] args) {
        int n=100;
        System.out.println(sum(n));
    }
    public static void print(int n){
        if(n<10) {
            System.out.print(n);
        }else {
            print(n / 10);
            System.out.print(n % 10 );
        }
    }

    public static void main3(String[] args) {
        int n=1234;
        print(n);
    }


    public static int func(int x){//阶乘方法
        if(x==1){
            return 1;
        }
        return x*func(x-1);
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("输入你要求的阶乘数: ");
        int x=sc.nextInt();
        System.out.println(func(x));
    }


    public static boolean isLeapYear(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }
        return false;
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入年份: ");
        int year = sc.nextInt();
        System.out.println(isLeapYear(year));
    }
}
