import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int []nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> List = threeSum(nums);
        System.out.println(List);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        List<List<Integer>> List = new ArrayList<>();
        while(i < nums.length - 2){
            if(i > 0 && nums[i] == nums[i-1] || nums[i] > 0) {
                i++;
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            int key = -nums[i];
            while(left < right){
                if(nums[left] + nums[right] < key){
                    left++;
                }else if(nums[left] + nums[right] > key){
                    right--;
                }else{
                    List.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
            i++;
        }
        return List;
    }
}