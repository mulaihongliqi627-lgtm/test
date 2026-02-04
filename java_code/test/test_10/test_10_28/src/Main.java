import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int []dp1 = new int[len+1];
        int []dp2 = new int[len+1];
        for(int i = 1;i <= len;i++){
            dp1[i] = dp1[i-1] + nums[i-1];
        }
        for(int i = len-2;i >=0;i--){
            dp2[i] = dp2[i+1] + nums[i+1];
        }
        for(int i = 0;i < len;i++){
            if(dp1[i] == dp2[i]){
                return i;
            }
        }
        return -1;
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash= new HashMap<Integer,Integer>();
        int len = nums.length;
        //hash.put(0,1);//提前预处理一个前缀和为0的
        int sum = 0,count = 0;
        for(int x : nums){
            sum += x;
            count += hash.getOrDefault(sum - k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int []nums = {1,2,1,4};
        int ret = subarraySum(nums,3);
        System.out.println(ret);
    }
}