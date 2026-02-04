import java.util.Arrays;

public class Main {

    public static int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public static void mergeSort(int []nums,int l,int r){
        //数组只剩一个元素或者不构成有效区间时结束划分
        if(l >= r){
            return;
        }
        int mid = (l + r)/2;
        //划分区间
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);

        //合并子数组
        int i =0;
        int[]arr = new int [r - l + 1];
        int cur1 = l,cur2 = mid + 1;
        while(cur1 <= mid && cur2 <= r){
            arr[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];
        }

        //遍历剩下的数组
        while(cur1 <= mid){
            arr[i++] = nums[cur1++];
        }
        while(cur2 <= r){
            arr[i++] = nums[cur2++];
        }

        //把排序好的数组复制到原始数组
        for(i = l;i <= r;i++){
            nums[i] = arr[i - l];
        }
    }
    public static void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int []nums = {1,4,7,2,5,8,3,6,9};
        int []arr = sortArray(nums);
        System.out.println(Arrays.toString(arr));
    }
}