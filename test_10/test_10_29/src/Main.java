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
    public static void main(String[] args) {
        int []nums = {4,5,0,-2,-3,1};
        int result = subarraysDivByK(nums,5);
        System.out.println(result);
    }
}