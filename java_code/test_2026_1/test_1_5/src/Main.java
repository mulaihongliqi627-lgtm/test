//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    private int [][]memo;//备忘录数组
    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];//访问1-n
        return dfs(1,n);
    }
    //dfs函数的任务:给定一个区间，这个区间内玩猜数字游戏获胜所需的最小本金
    public int dfs(int left,int right){
        if(left >= right) {
            return 0;//已经获胜，无需花钱
        }
        if(memo[left][right] != 0){//这个区间内已经被猜过，无需重复操作，剪枝
            return memo[left][right];//剪枝
        }
        int money = Integer.MAX_VALUE;//假定初始本金无限大，寻求确保游戏获胜所需的最小本金
        for(int head = left;head <= right;head++){
            //递归左右子树，得到分别所需的本金
            int x = dfs(left,head-1);
            int y = dfs(head+1,right);
            money = Math.min(Math.max(x,y)+head,money);//内层取max确保无论目标数字是哪一个，都能确保左右子树都获胜，避免输掉
        }
        memo[left][right] = money;//填写备忘录
        return money;
    }
}