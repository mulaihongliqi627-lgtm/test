import java.util.Scanner;

public class Main {
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for(int i = 1; i < len;i++){
            dp1[i] = dp1[i-1] + nums[i-1];
        }
        for(int i = len - 2;i >= 0;i--){
            dp2[i] = dp2[i+1]+nums[i+1];
        }
        for(int i = 0;i < len;i++){
            if(dp1[i] == dp2[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {2, 1, -1};
        int result = pivotIndex(nums);
        System.out.println(result);
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int [][]arr = new int[n+1][m+1];//原始数组,存储输入的数据
        long [][]dp = new long[n+1][m+1];//dp数组,存储区域元素和
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                arr[i][j] = in.nextInt();
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];
            }
        }
        while(q > 0){
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            int y1 = in.nextInt();
            int y2 = in.nextInt();
            long ret = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            System.out.println(ret);
            q--;
        }
    }
}