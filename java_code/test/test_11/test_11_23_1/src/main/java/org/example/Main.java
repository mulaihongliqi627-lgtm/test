package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    private static int[]tmp;
    public static int reversePairs(int[] nums) {
        tmp = new int [nums.length];
        return merge(nums,0,nums.length-1);
    }
    public static int merge(int []nums,int left,int right){
        if(right - left + 1 <= 1){//数组长度太短
            return 0;
        }
        int count = 0;
        int mid = (left + right)/2;
        count += merge(nums,0,mid);
        count += merge(nums,mid + 1,right);
        int cur1 = left,cur2 = mid + 1,i = 0;
        //计算逆序对
        while(cur1 != mid && cur2 != right){
            if(nums[cur1] > 2*nums[cur2]){
                count += mid - cur1 + 1;
                cur2++;
            }else{
                cur1++;
            }
        }
        cur1 = left;
        cur2 = mid + 1;
        //维护升序数组
        while(cur1 <= mid && cur2 <= right){
            if(nums[cur1] > nums[cur2]){
                tmp[i++] = nums[cur2++];
            }else{
                tmp[i++] = nums[cur1++];
            }
        }
        //处理没有遍历完的数组
        while(cur1 <= mid){
            tmp[i++] = nums[cur1++];
        }
        while(cur2 <= right){
            tmp[i++] = nums[cur2++];
        }
        //把tmp数组拷贝到nums数组，令其有序
        for(int j = left;j <= right;j++){
            nums[j] = tmp[j];
        }
        return count;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[]arr = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(hash.containsKey(target - nums[i])){//找到元素
                arr[0] = hash.get(target - nums[i]);
                arr[1] = i;
                return arr;
            }
            hash.put(nums[i],i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int []nums = {3,2,4};
        int []ret = twoSum(nums,6);
        System.out.println(Arrays.toString(ret));
    }
}