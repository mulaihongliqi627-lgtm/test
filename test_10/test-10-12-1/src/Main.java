public class Main {
    public static void main(String[] args) {
        int []nums = {3,2,20,1,1,3};
        int k = 10;
        int result = minOperations(nums,k);
        System.out.println(result);
    }
    public static int longestOnes(int[] nums, int k) {
        int zero = 0;
        int len = 0;
        for(int left = 0,right = 0;right < nums.length;right++){
            if(nums[right] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[left++] == 0){
                    zero--;
                }
            }
            len = Math.max(len,right-left+1);//更新长度
        }
        return len;
    }

    public static int minOperations(int[] nums, int x) {
        int sum = 0,len = 0,flag = 0;
        int total_sum = sum(nums);//整个数组元素之和
        int key = total_sum - x;
        if(key < 0){
            return -1;
        }
        for(int left = 0,right = 0;right < nums.length;right++){
            sum += nums[right];//进窗口
            while(sum > key){
                sum -= nums[left++];//出窗口
            }
            if(sum == key) {
                flag = 1;
                len = Math.max(len, right - left + 1);//更新结果
            }
        }
        if(flag == 0){
            return -1;
        }
        return nums.length - len;
    }
    public static int sum(int[]nums){
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        return sum;
    }
}