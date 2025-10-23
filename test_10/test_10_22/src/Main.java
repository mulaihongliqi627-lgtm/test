public class Main {
    public static int mySqrt(int x) {
        if(x < 1){
            return 0;
        }
        long left=  1,right = x;
        while(left < right){
            long mid = left + (right - left + 1)/2;
            if(mid*mid <= x){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return (int)left;
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] >= target){
                right = mid;
            }
        }
        if(nums[left] < target){
            return left+1;
        }
        return left;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0,right = arr.length-1;
        while(left < right){
            int mid = left + (right - left+1)/2;
            if(arr[mid] >= arr[mid-1]){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[]nums = {0,1,0};
        int ret = peakIndexInMountainArray(nums);
        System.out.println(ret);
    }
}