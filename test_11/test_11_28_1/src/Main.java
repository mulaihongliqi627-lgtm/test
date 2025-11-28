import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入，例如 20200202
        String inputDate = scanner.next();
        scanner.close();

        // 定义日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 解析当前日期，并从第二天开始查找
        LocalDate date = LocalDate.parse(inputDate, formatter);

        boolean foundNextPalindrome = false;
        boolean foundNextABAB = false;

        String resultPalindrome = "";
        String resultABAB = "";

        // 循环直到找到两种日期
        while (!foundNextPalindrome || !foundNextABAB) {
            // 日期加1天
            date = date.plusDays(1);
            String dateStr = date.format(formatter);

            // 1. 检查是否是回文日期
            if (isPalindrome(dateStr)) {
                if (!foundNextPalindrome) {
                    resultPalindrome = dateStr;
                    foundNextPalindrome = true;
                }

                // 2. 检查是否是 ABABBABA 型回文日期
                // 注意：只有是回文日期才有可能是 ABABBABA
                if (!foundNextABAB && isABABBABA(dateStr)) {
                    resultABAB = dateStr;
                    foundNextABAB = true;
                }
            }
        }

        System.out.println(resultPalindrome);
        System.out.println(resultABAB);
    }

    // 判断字符串是否是回文
    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    // 判断是否是 ABABBABA 格式 (例如 20200202)
    // 这里的逻辑基于已经确定 s 是回文 (Palindrome)
    private static boolean isABABBABA(String s) {
        char A = s.charAt(0);
        char B = s.charAt(1);

        // A 不能等于 B
        if (A == B) return false;

        // 既然已经是回文，只要前4位是 ABAB 即可
        // 0 1 2 3 4 5 6 7
        // A B A B B A B A
        return s.charAt(2) == A && s.charAt(3) == B;
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        while (!check1(str) || !check2(str)){

        }
    }
    //判断是否是回文日期
    public static boolean check1(String str){
        if(str.charAt(0) == str.charAt(7)
                && str.charAt(1) == str.charAt(6)
                && str.charAt(2) == str.charAt(5)
                && str.charAt(3) == str.charAt(4)){
            return true;
        }
        return false;
    }
    //判断是否是ABABBABA 型的回文日期
    public static boolean check2(String str){
        if(str.charAt(0) == str.charAt(7)
                && str.charAt(1) == str.charAt(6)
                && str.charAt(2) == str.charAt(5)
                && str.charAt(3) == str.charAt(4)
                && str.charAt(0) == str.charAt(2)
                && str.charAt(1) == str.charAt(3)
                && str.charAt(0) != str.charAt(1)){
            return true;
        }
        return false;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        //处理输入值
        int n = sc.nextInt();
        long []arr = new long[n + 1];
        long []dp = new long[n + 1];
        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextLong();
            dp[i] = dp[i-1] + arr[i];
        }
        long result = 0;
        for(int i = 1;i <= n-1;i++){
            result += (dp[i] - dp[i-1]) * (dp[(int )n]- dp[i]);
        }
        System.out.println(result);
    }
}