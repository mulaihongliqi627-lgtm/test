import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        int[][] dp = new int[m + 1][n + 1];
        int max_len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= m; i++) {//dp数组初始化
            for (int j = 1; j <= n; j++) {
                if (arr[i - 1][j - 1] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max_len = Math.max(dp[i][j], max_len);
                }
            }
        }
        System.out.println(max_len);
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("abcde");
        s.insert(1,'w');
        System.out.println(s);
    }

}