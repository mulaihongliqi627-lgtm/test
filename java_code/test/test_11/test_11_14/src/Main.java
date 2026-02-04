import java.util.Random;

public class Main {

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length - 1,k);
    }
    public static int quickSort(int []nums,int l,int r,int k){
        if(l == r){
            return nums[l];
        }
        int base = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1,right = r + 1,i = l;
        //数组分三块
        while(i < right){
            if(nums[i] < base){
                swap(nums,++left,i++);
            }else if(nums[i] == base){
                i++;
            }else{
                swap(nums,i,--right);
            }
        }
        //计算每个区间内元素个数
        int a = left - l + 1,b = right - left - 1,c = r - right + 1;
        if(k <= c){//递归右区间
            return quickSort(nums,right,r,k);
        }else if(k <= b + c){//返回中间元素
            return nums[left + 1];
        }else{//递归左区间
            return quickSort(nums,l,left,k - b - c);
        }
    }
    public static void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int reversePairs(int[]nums) {
        return mergeSOrt(nums,0,nums.length);
    }

    public static int mergeSOrt(int []nums,int left ,int right){
        if(left >= right){
            return 0;
        }
        int mid = (left + right) / 2,ret = 0;
        ret += mergeSOrt(nums,left,mid);//左区间找逆序对
        ret += mergeSOrt(nums,mid+1,right);//右区间找逆序对
        //一左一右寻找逆序对
        int cur1 = left,cur2 = mid + 1,i = 0;
        while(cur1 <= mid && cur2<= right){
            if(nums[cur1] > nums[cur2]){
                ret += mid - cur1 + 1;
                tmp[i++] = nums[cur2++];
            }else{
                tmp[i++] = nums[cur1++];
            }
        }

        //处理未遍历完的数组
        while(cur1 <= mid){
            tmp[i++] = nums[cur1++];
        }
        while(cur2 <= right){
            tmp[i++] = nums[cur2++];
        }
        //把两个有序数组合并
        for(int j = left;j <= right;j++){
            nums[j] = tmp[j - left];
        }
        return ret;
    }
    public static void main(String[] args) {
        int []nums = {9, 7, 5, 4, 6};
        int result = reversePairs(nums);
        System.out.println(result);
    }
}