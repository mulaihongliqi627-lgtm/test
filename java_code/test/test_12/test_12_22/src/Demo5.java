public class Demo5 {
    private boolean[][]visit;
    private int sumOre = 0;//总挖矿数
    private int m,n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0){//找到矿
                    visit[i][j] = true;//标记为已经挖了
                    dfs(grid,i,j,grid[i][j]);
                    visit[i][j] = false;//上一个方案结束了，但不一定是最大挖矿数的方案，继续遍历
                }
            }
        }
        return sumOre;
    }
    //坐标偏移量
    int dx[] = {0,0,-1,1};
    int dy[] = {-1,1,0,0};
    //以该位置为起点来挖矿,返回挖到的矿的个数


    public void dfs(int [][]grid,int i,int j,int count){
        sumOre = Math.max(count,sumOre);
        for(int k = 0;k < 4;k++){
            int x = i +dx[k];int y = j + dy[k];
            if(x >=0 && x < m && y >=0 && y < n && !visit[x][y] && grid[x][y] != 0){
                visit[x][y] = true;
                dfs(grid,x,y,count + grid[x][y]);
                visit[x][y] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
