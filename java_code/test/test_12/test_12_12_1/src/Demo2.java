public class Demo2 {
    private static int sum;
    private static int path;
    private static int pos;
    public static int subsetXORSum(int[] nums) {
        sum = 0;
        path = 0;
        dfs(nums,pos);
        return sum;
    }
    public static void  dfs(int[]nums,int pos){
        sum += path;//一进入递归就代表到了一个新节点，添加path
        for(int i = pos;i < nums.length;i++){
            path ^= nums[i];
            dfs(nums,i+1);
            path ^= nums[i];//连续异或同一个数字，回溯
        }
    }
    public static void main(String[] args) {
        int []arr ={5,1,6};
        int ret = subsetXORSum(arr);
        System.out.println(ret);
    }
}
