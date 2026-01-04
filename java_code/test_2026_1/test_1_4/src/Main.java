//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    private int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int []arr = new int[n];//备忘录数组
        int ret = 0;
        for(int i = 0;i < n;i++){
            ret = Math.max(ret,dfs(nums,i,arr));
        }
        return ret;
    }
    //dfs函数功能，找出以pos为起点的最长子序列长度并返回
    public int dfs(int []nums,int pos,int []arr){
        if(arr[pos] != 0) {
            return arr[pos];//pos起点的长度已经被计算过了，无需重复计算
        }
        int ret = 1;//防止pos为数组nums末尾元素时导致进不去循环无返回结果
        for(int i = pos + 1;i < n;i++){
            if(nums[i] > nums[pos]){//后面的元素递增
                ret = Math.max(ret,dfs(nums,i,arr)+1);//从pos+1位置开始往后找最长子序列，需加1
            }
        }
        arr[pos] = ret;//return之前添加结果到arr备忘录数组中
        return ret;
    }
}

