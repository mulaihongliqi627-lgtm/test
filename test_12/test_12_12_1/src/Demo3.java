import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo3 {
    private static List<List<Integer>> list;
    private static List<Integer>path;
    private static  boolean[] check;
    public static List<List<Integer>> permuteUnique(int[] nums) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        check = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return list;
    }
    public static void dfs(int []nums){
        if(path.size() == nums.length){
            list.add(new ArrayList<>(path));
        }
        for(int i = 0;i < nums.length;i++){
            if(check[i] == false && (i == 0 || nums[i] != nums[i-1] || check[i-1] == true)){
                check[i] = true;
                path.add(nums[i]);
                dfs(nums);
                path.remove(path.size() - 1);//回溯，恢复现场
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[]nums = {1,1,2};
        List<List<Integer>> ret = permuteUnique(nums);
        System.out.println(ret);

    }
}
