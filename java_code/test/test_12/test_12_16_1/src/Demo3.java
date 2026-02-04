import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo3 {


    private  List<List<Integer>> list;
    private  List<Integer> path;
    private  int key;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        key = target;
        dfs(nums,0,0);
        return list;
    }
    public void dfs(int[]nums,int sum,int pos){
        if(sum == key){
            list.add(new ArrayList<>(path));
            return;
        }
        if(sum > key) return;//剪枝
        for(int i = pos;i < nums.length;i++){
            path.add(nums[i]);
            sum += nums[i];
            dfs(nums,sum,i);//一个数字可以重复使用
            path.remove(path.size()-1); sum -= nums[i];//回溯
        }
    }
    public static void main(String[] args) {
        int []nums = {2,3,5};
        List<List<Integer>> ret = new Demo3().combinationSum(nums,8);
        System.out.println(ret);
    }
}
