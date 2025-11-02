public class Main {

    public static boolean isUnique(String s) {
        int []arr = new int[32];
        for(int i = 0;i < s.length();i++){
            int x = s.charAt(i) - 'a';
            arr[x]++;//表示该字符出现过一次
            if(arr[x] > 1){
                return false;
            }
        }
        return true;
    }
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for(int i = 0; i < 32;i++){//遍历每一个比特位
            int sum = 0;
            for(int x : nums){//统计数组中每一个数组的每一个对应的比特位的和
                if(((x>>i)&1) == 1){
                    sum++;
                }
            }
            if(sum % 3 ==1){
                ret |= (1 << i);
            }
        }
        return ret;
    }
    public static  int missingNumber(int []nums){
        int []arr = new int[nums.length+1];
        int x = 0;
        for(int i = 0;i < nums.length;i++){
            x ^= nums[i];
        }
        for(int i = 0;i <= nums.length;i++){
            x ^= i;
        }
        return x;
    }
    public static int getSum(int a, int b) {
        while(b != 0){
            int x = a^b;//无进位相加
            int y = (a&b)<<1;//进位相加
            a = x;
            b = y;
        }
        return a;
    }
    public static int missingNumber1(int[] nums) {
        int []arr = new int[nums.length+1];
        for(int i = 0;i < nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int []nums = {0,1,0,1,0,1,99};
        int result = singleNumber(nums);
        System.out.println(result);
    }
}