//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int m,n,step,ret;
    private boolean[][]visit;
    public int uniquePathsIII(int[][] grid) {
        //计算需要的步数
        ret = 0;//方案数
        m = grid.length;n = grid[0].length;
        step = 0;//需要的目标步数
        int x = 0,y = 0;
        visit = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 0) step++;
                else if (grid[i][j] == 1) {
                    visit[i][j] = true;
                    x = i;y = j;
                }
            }
        }
        step += 2;
        dfs(grid,x,y,1);
        return ret;
    }
    int []dx = {0,0,1,-1};
    int []dy = {-1,1,0,0};
    public void dfs(int[][] grid,int i,int j,int count){
        if(grid[i][j] == 2){//走到终点
            if(count == step){
                ret++;
            }
            return;
        }
        for(int k = 0;k < 4;k++){//四个方向尝试
            int x = i + dx[k],y = j + dy[k];
            if(x >= 0 && x < m && y >=0 && y < n && !visit[x][y] && grid[x][y] != -1){
                visit[x][y] = true;
                dfs(grid,x,y,count+1);
                visit[x][y] = false;
            }
        }
    }
    public static void main(String[] args) {


    }
}