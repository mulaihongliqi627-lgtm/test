import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public static void quickSort(int []nums,int l,int r){
        if(l > r){
            return;
        }
        //使用生成随机数法寻找基准值
        int base = nums[new Random().nextInt(r-l+1)+l];
        //定义三个指针
        int left = l-1,right = r+1,i = l;
        while(i < right){
            if(nums[i] < base){
                swap(nums,++left,i++);
            }else if(nums[i] == base){
                i++;
            }else{
                swap(nums,i,--right);
            }
        }
        quickSort(nums,l,left);
        quickSort(nums,right,r);
    }
    public static void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSort1(nums,0,nums.length-1,k);
    }
    public static int quickSort1(int []nums,int l,int r,int k){
        if(r == l){
            return nums[l];
        }
        int left = l-1,right = r+1,i = l;
        int base = nums[new Random().nextInt(r-l+1)+l];
        while (i < right){
            if(nums[i] < base){
                swap(nums,++left,i++);
            }else if(nums[i] == base){
                i++;
            }else{
                swap(nums,i,--right);
            }
        }
        //计算每一个区域内数组内元素的个数
        int a = left - l + 1,b = right - left - 1,c = r - right + 1;
        if(k <= c){//在右区域
            return quickSort1(nums,right,r,k);
        }else if (k <= b + c) {//中间区域
            return nums[left + 1];
        }else {//左边区域
            return quickSort1(nums, l, left, k - b - c);
        }
    }
    public static void main(String[] args) {
        int []nums = {-1,0,2};
        int result = findKthLargest(nums,2);
        System.out.println(result);
    }
}