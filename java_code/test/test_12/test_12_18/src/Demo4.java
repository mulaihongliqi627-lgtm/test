import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo4 {
    private char[][] path;
    private List<List<String>> list;
    private boolean[] cols;//列是否可以放置
    private boolean[] dig1;//主对角线是否可以放置
    private boolean[] dig2;//副对角线是否可以放置
    private int x;//矩阵的阶数
    public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        list = new LinkedList<>();
        cols = new boolean[n];
        dig1 = new boolean[2*n];
        dig2 = new boolean[2*n];
        x = n;
        for(int i = 0;i < n;i++){//初始化arr
            for(int j = 0;j < n;j++){
                path[i][j] = '.';
            }
        }
        dfs(0);
        return list;
    }
    public void dfs(int row){
        if(row == x){
            List<String> tmp = new LinkedList<>();
            //把path结果添加到list
            for(int i = 0;i < x;i++){
                tmp.add(new String(path[i]));//每一行添加
            }
            list.add(tmp);
        }
        for(int j = 0;j < x;j++){//遍历每一列
            //列，主对角线和副对角线都不会被攻击
            if(cols[j] == false && dig1[j-row+x] == false && dig2[row+j] == false){
                cols[j] = dig1[j-row+x] = dig2[row+j] = true;
                path[row][j] = 'Q';
                dfs(row+1);
                //恢复现场
                path[row][j] = '.';
                cols[j] = dig1[j-row+x] = dig2[row+j] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> result = new Demo4().solveNQueens(4);
        System.out.println(result);
    }
}
