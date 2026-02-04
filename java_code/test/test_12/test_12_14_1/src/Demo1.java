public class Demo1 {
    private int sum;
    private int path;//计算每一次path的数字和
    private static int key = 0;

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;path = 0;
        key = target;
        dfs(nums,0,0);
        return sum;
    }
    public void dfs(int []nums,int path,int pos){
        if(pos == nums.length){
            if(path == key) sum++;
            return;
        }
        dfs(nums,path+nums[pos],pos+1);
        dfs(nums,path-nums[pos],pos+1);
    }

    public static void main(String[] args) {
        int []nums = {1};
        int ret = new Demo1().findTargetSumWays(nums,1);
        System.out.println(ret);
    }
}
