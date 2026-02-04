import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0,count = 0;
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
        for(int x : nums){
            sum += x;
            int a = (sum % k + k) % k;
            count += hash.getOrDefault(a,0);
            hash.put(a,hash.getOrDefault(a,0)+1);
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash= new HashMap<Integer,Integer>();
        int len = nums.length;
        hash.put(0,1);//提前预处理一个前缀和为0的
        int sum = 0,count = 0;
        for(int x : nums){
            sum += x;
            count += hash.getOrDefault(sum - k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash= new HashMap<>();
        hash.put(0,-1);
        int ret  = 0,sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += (nums[i] == 0 ? -1 : 1);
            if(hash.containsKey(sum)){
                ret = Math.max(ret,i - hash.get(sum));
            }else{
                hash.put(sum,i);
            }
        }
        return ret;
    }
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int [][]dp = new int[m+1][n+1];//前缀和数组
        int [][]ans = new int[m][n];//返回的数组
        //创建前缀和数组
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for(int i = 0; i < m;i++){
            for(int j = 0;j < n;j++){
                //为什么坐标要加1？因为需要去dp数组中找对于的坐标，但是dp数组坐标从1开始
                int x1 = Math.max(0,i-k) + 1;
                int y1 = Math.max(0,j-k) + 1;
                int x2 = Math.min(m-1,i+k) + 1;
                int y2 = Math.min(n-1,j+k) + 1;
                ans[i][j] = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][]mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = matrixBlockSum(mat,1);
        System.out.println(Arrays.deepToString(result));
    }
}