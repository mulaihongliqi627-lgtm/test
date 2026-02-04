import java.util.Arrays;

public class Main {

    public static void sortColors(int[] nums) {
        int i = 0,left = -1,right = nums.length;
        while (i < right){
            if(nums[i] == 0){
                swap(nums,i++,++left);
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums,i,--right);
            }
        }
    }
    public static int[] sortArray(int[] nums) {

        return  nums;
    }
    public static void quickSort(int []nums,int left,int right){
        //先对整体数组做一次快排分成两个区间
        int partition = partition(nums,0,nums.length-1);
        //在对左区间快排
        quickSort(nums,0,partition);
        //对右区间快排
        quickSort(nums,partition+1,nums.length-1);
    }
    //分治，把数组分成两个区域
    public static int  partition(int []nums,int start ,int end){
        int base = nums[start];
        int left = start,right = end;
        while (left < right){
            if(nums[right] <= base){
                swap(nums,left++,right);
            }else{
                right--;
            }
            if(nums[left] > base){
                swap(nums,left,right--);
            }else{
                left++;
            }
        }
        //此时left和right相遇
        return left;
    }

    public static void swap(int []arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]  = tmp;
    }
    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}