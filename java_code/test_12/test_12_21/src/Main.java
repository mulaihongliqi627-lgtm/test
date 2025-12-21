//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private char[][]arr;
    private StringBuilder path = new StringBuilder();
    private String s;
    private int k;
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        arr = new char[m][n];
        for(int i = 1;i <= m;i++){//初始化arr数组
            for(int j = 1;j <= n;j++){
                arr[i][j] = board[i-1][j-1];
            }
        }
        k = 0;
        s = word;
        return dfs(board,1,1);
    }
    public boolean dfs(char[][]arr,int i,int j){
        if(path.length() == s.length()){
            return true;
        }
        //检查当前位置是否可以作为word的起点
        if(arr[i][j] != s.charAt(k)){
            return false;
        }
        path.append(arr[i][j]);
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
        dfs(arr,i,j-1);
        dfs(arr,i,j+1);
        return true;
    }
    public static void main(String[] args) {

    }
}