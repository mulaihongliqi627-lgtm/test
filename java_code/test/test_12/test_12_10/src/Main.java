import java.util.Scanner;

public class Main {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int [][]dp = new int [m+1][n+1];
        //边界初始化
        for(int i = 0;i <= n;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i <= m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[1][0] = 0;
        dp[0][1] = 0;
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
    public int calculateMinimumHP(int[][] arr) {
        int m = arr.length,n = arr[0].length;
        int [][]dp = new int[m+1][n+1];
        for(int i = 0;i <= n;i++){
            dp[m][i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i <= m;i++){
            dp[i][n] = Integer.MAX_VALUE;
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for(int i = m-1;i >= 0;i--){
            for(int j = n-1;j >= 0;j--){
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) - arr[i][j];
                dp[i][j] = Math.max(1,dp[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (m-- > 0){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
        }
        int cluster = 0;
        int x = Integer.MAX_VALUE;
    }
}