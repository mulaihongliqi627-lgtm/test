import java.util.Arrays;

public class Main {
    public static int[] searchRange(int[] nums, int target) {
        int []arr = {-1,-1};
        if(nums.length == 0){
            return arr;
        }
        int left = 0,right = nums.length-1;
        int start = 0,end = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                arr[0] = mid;
                arr[1] = mid;
                start = mid;
                end = mid;
                while(start > 0 && nums[start-1] == nums[start]){//边界处理
                    start--;
                    arr[0] = start;
                }
                while(end < nums.length-1 && nums[end] == nums[end+1]){
                    end++;
                    arr[1] = end;
                }
                return arr;
            }
        }
        return arr;
    }
    public static int[] searchRange2(int[] nums, int target) {
        int []arr = {-1,-1};
        int left = 0,right = nums.length-1;
        if(nums.length == 0){
            return arr;
        }
        while(left < right){//查找左端点
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] >= target){
                right = mid;
            }
        }
        if(nums[left] != target){
            return arr;
        }else{
            arr[0] = left;
        }
        left = 0;
        right = nums.length - 1;
        while(left < right){//查找右端点
            int mid = left + (right - left + 1)/2;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        if(nums[left] != target){
            return arr;
        }else{
            arr[1] = left;
        }
        return arr;

    }
    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int[] arr = searchRange2(nums,6);
        System.out.println(Arrays.toString(arr));
    }
}