//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int ret = 0;
    private int []dx = {0,0,1,-1};
    private int []dy = {1,-1,0,0};
    private int m,n;
    private int [][]memo;//备忘录数组
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;n = matrix[0].length;
        memo = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                ret = Math.max(dfs(matrix,i,j),ret);
            }
        }
        return ret;
    }
    //dfs函数功能:给定一个坐标，返回以这个坐标为起始位置的最长递增路径长度
    public int dfs(int[][] matrix,int i,int j){
        if(memo[i][j] != 0){//已经被计算过
            return memo[i][j];
        }
        int maxLen = 1;
        for(int k = 0;k < 4;k++){
            //计算偏移坐标
            int x = dx[k] + i;
            int y = dy[k] + j;
            if(x >= 0 && x < m && y >= 0 && y < n&& matrix[x][y] > matrix[i][j]){
                maxLen = Math.max(maxLen,dfs(matrix,x,y)+1);
            }
        }
        memo[i][j] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4}, {6,6,8},{2,1,1}};
        int len = new Main().longestIncreasingPath(matrix);
        System.out.println(len);
    }
}
