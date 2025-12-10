import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo2 {
    static List<List<Integer>> list;
    static List<Integer> path;
    static int l;
    public List<List<Integer>> subsets(int[] nums) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        l = nums.length;
        dfs(nums,0);
        return list;
    }
    public static void dfs(int []nums,int l){
        if(l == nums.length){
            list.add(new ArrayList<>(path));
            return;
        }
        //选择当前元素
        path.add(nums[l]);
        dfs(nums,l+1);
        path.remove(path.size() - 1);//回溯
        //不选
        dfs(nums,l+1);
    }

    public static void main(String[] args) {

    }
}
