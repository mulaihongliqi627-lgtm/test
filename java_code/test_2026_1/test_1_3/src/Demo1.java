public class Demo1 {
    private int [][]arr;//备忘录
    public int uniquePaths(int m, int n) {
        arr = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){//初始化备忘录
            for (int j = 1;j <= n;j++){
                arr[i][j] = -1;
            }
        }
        return dfs(m,n);
    }
    public int dfs(int i,int j){
        //查找备忘录，以及计算过时
        if(arr[i][j] != -1){
            return arr[i][j];
        }
        if(i == 0 || j == 0){
            arr[i][j] = 0;
            return 0;
        }
        if(i == 1 && j == 1){
            arr[i][j] = 1;
            return arr[i][j];
        }
        arr[i][j] = dfs(i-1,j) + dfs(i,j-1);
        return arr[i][j];
    }
}
