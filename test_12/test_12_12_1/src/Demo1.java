import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    private static List<List<Integer>> list;
    private static List<Integer> path;
    private int l;
    public static int subsetXORSum(int[] nums) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        dfs(nums,0);
        int sum = 0;
        for(int i = 0;i < list.size();i++){
            int result = 0;
            Object []arr = list.get(i).toArray();
            for(int j = 0;j < arr.length;j++){
                result ^= (int)arr[j];
            }
            sum += result;
        }
        return sum;
    }
    //求集合的全部子集
    public static void dfs(int []nums,int l){
        list.add(new ArrayList<>(path));
        for(int i = l;i < nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[]nums = {3,4,5,6,7,8};
        int result = subsetXORSum(nums);
        System.out.println(result);
    }
}
