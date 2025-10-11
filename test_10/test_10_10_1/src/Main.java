public class Main {
    public static void main(String[] args) {
        int []nums = new int []{2,3,1,2,4,3};
        int result = minSubArrayLen(7,nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE,sum = 0;
        while(right < nums.length){
            sum += nums[right];//进窗口
            while(sum >= target){
                int ret = right-left+1;//计算子数组长度
                len = Math.min(len,ret);
                sum-=nums[left++];
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    //复写零
    public void duplicateZeros(int[] arr) {
        int cur = 0;
        int dest = -1;
        while(cur < arr.length){
            if(arr[cur] == 0){
                dest+=2;
            }else{
                dest++;
            }
            if(dest >= arr.length-1){
                break;
            }else{
                cur++;
            }
        }
        if(dest == arr.length){//处理越界情况
            arr[arr.length-1] = 0;
            dest-=2;
            cur--;
        }
        while(cur >= 0){//复写操作
            if(arr[cur] == 0){
                arr[dest] = 0;
                arr[dest-1] = 0;
                dest-=2;
                cur--;
            }else{
                arr[dest--] = arr[cur--];
            }
        }
    }
}