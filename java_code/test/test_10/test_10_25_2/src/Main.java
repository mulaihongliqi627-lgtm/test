public class Main {
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid_index = left+(right - left)/2;
            int mid = nums[mid_index];
            if(mid < target){//target在mid右边,左边区域舍去
                left = mid_index+1;
            }else if(mid > target){//target在mid左边,右边区域舍去
                right = mid_index-1;
            }else{
                return mid_index;
            }
        }
        return -1;
    }
    public static int takeAttendance(int[] records) {
        int left = 0,right = records.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(records[mid] == mid){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return records[left] == left ? left+1 : left;
    }

    public static int[] searchRange(int[] nums, int target) {
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
    public static int mySqrt(int x) {
        if(x < 1){
            return 0;
        }
        long left = 1,right = x;
        while(left < right){
            long mid = left+(right - left+1)/2;
            if(mid*mid <= x){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return (int)left;
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left < right){
           int mid = left+(right - left+1)/2;
           if(nums[mid] <= target){
               left = mid;
           }else {
               right = mid-1;
           }
        }
        if(nums[left] < target){
            return left+1;
        }
        return left;

    }

    public static void main(String[] args) {
        int a = new Integer(114);
        int b = new Integer(a);
        b = 514;
        System.out.println(a);
        System.out.println(b);
    }
}