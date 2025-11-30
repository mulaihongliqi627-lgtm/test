package demo;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //三步上台阶问题
    public static int waysToStep(int n) {
        int MOD = (int)1e9 + 7;
        int []dp = new int [n + 1];
        dp[1] = 1;dp[2] = 2;dp[3] = 4;
        if(n == 1 || n == 2){
            return n;
        }
        if(n == 3){
            return 4;
        }
        for(int i = 4;i <= n;i++){
            dp[i] = ((dp[i - 1] + dp[i - 2])%MOD + dp[i - 3])%MOD;
        }
        return dp[n];
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result= waysToStep(n);
        System.out.println(result);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = a;i <= b;i++){
            if(isSquareNum(i) && check(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean check(int x){
        String s = String.valueOf(x);//把数字转化为字符串
        //尝试对x拆分，查看是否是由平方数组合构成
        for(int i = 0;i < s.length() - 1;i++){
            //字符串截取
            String s1 = s.substring(0,i+1);
            String s2 = s.substring(i+1,s.length());
            int num1 = Integer.valueOf(s1);
            int num2 = Integer.valueOf(s2);
            if(isSquareNum(num1 ) && isSquareNum(num2)){//拆分的两个数都是平方数
                return true;
            }
        }
        return false;
    }
    //判断一个数是否是平方数
    public static boolean isSquareNum(int x){
        if(x <= 0){
            return false;
        }
        long a = (long) Math.sqrt(x);
        return Math.pow(a,2) == x;
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 1;
        for (int i = 1; i < n; i++) {
            double x = (1.0 * i) / (i + 1);
            sum += Math.pow(-1,i) * x;
        }
        String ret = String.format("%.2f",sum);
        System.out.println(ret);
    }
    public static int numDecodings(String s) {
        char []arr = s.toCharArray();
        int n = s.length();
        int []dp = new int [n + 1];
        //初始化
        if(Decoding(s.substring(0,1))){
            dp[0] = 1;
        }else{
            dp[0] = 0;
        }
        if(Decoding(s.substring(0,2)) && Decoding(s.substring(0,1)) && Decoding(s.substring(1,2))){
            dp[1] = 2;
        }else if(s.length() > 2 && Decoding(s.substring(0,2)) || (Decoding(s.substring(0,1)) && Decoding(s.substring(1,2)))){
            dp[1] = 1;
        }else {
            dp[1] = 0;
        }
        for(int i = 2;i < n;i++){
            if(Decoding(s.substring(i,i+1))){//只解码一个
                dp[i] += dp[i-1];
            }
            if(Decoding(s.substring(i-1,i + 1))){//解码两个
                dp[i] += dp[i-2];
            }
        }
        return dp[n-1];
    }
    //判断一个字符串是否可以被成功解码
    public static boolean Decoding(String s){
        if(s.charAt(0) - '0' == 0){//0不能被解码
            return false;
        }
        if(s.length() == 1){//单个字符解码
            int x = Integer.valueOf(s);
            if(x >= 0 && x <= 9){
                return true;
            }
        }
        if(s.length() == 2){//双字符解码
            int x = (s.charAt(0) - '0')* 10 + s.charAt(1)- '0';
            if(x >= 10 && x <= 26){
                return true;
            }
        }
        return false;
    }

    public static void main4(String[] args) {
        String s = "226";
        int x = numDecodings(s);
        System.out.println(x);
    }

    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []arr = new int [26];
        int n = sc.nextInt();
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= i;j++){
                int result = Mult(i,j,n);
                char x = (char)( i + '0');
                char y = (char)( j + '0');
                if(i >= 10){
                    x = (char) ('A' + i - 10);
                }
                if(j >= 10){
                    y = (char) ('A' + j - 10);
                }
                if(result/10 == 0){
                    System.out.print(x+"*"+y+"="+result%10 + " ");
                    continue;
                }
                System.out.print(x+"*"+y+"="+result/10 + result%10 + " ");
            }
            System.out.println();//换行
        }
    }

    //n进制运算结果
    public static int Mult(int x,int y,int n){
        int ret = x * y;
        return (ret/n) *10 + ret % n;
    }

    public static void main6(String[] args) {
        int x = 12;
        char ch = (char) ('A' + x - 10);
        System.out.println(ch);
    }
    public static String convert(int x,int n){
        if(x ==0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        //进制转化
        while (x > 0){
            int ret = x % n;
            if(ret < 10){
                s.append(ret);
            }else{
                s.append((char) ('A' + ret - 10));
            }
            x /= n;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i < n;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(convert(i,n) + "*" + convert(j,n) + "=" + convert(i * j,n) + " ");
            }
            System.out.println();
        }
    }

    public static void main79(String[] args) {
        String str= convert(21, 8);
        System.out.println(str);
    }
}
