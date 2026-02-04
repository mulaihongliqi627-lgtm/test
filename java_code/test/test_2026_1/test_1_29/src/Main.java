//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public int massage(int[] nums) {
        int n = nums.length;
        int []f = new int [n+1];//f[i]:表示以i位置选择时的最大时长
        int []g=  new int [n+1];//g[i]表示以i位置不选择时的最大时长
        f[0] = nums[0];
        for(int i = 1;i < n;i++){
            f[i] = nums[i] + g[i-1];//当前位置选择，前一个不选
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return Math.max(f[n-1],g[n-1]);
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        int ret = new Main().massage(nums);
        System.out.println(ret);
    }
}