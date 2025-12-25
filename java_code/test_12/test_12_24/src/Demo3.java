public class Demo3 {
    private int maxIsland,m,n;
    private boolean[][]visit;
    public int maxAreaOfIsland(int[][] grid) {
        maxIsland = 0;
        m = grid.length;n = grid[0].length;
        visit = new boolean[m][n];
        for(int i =0 ;i < m;i++){
            for(int j = 0;j < n;j++){
                if(!visit[i][j] && grid[i][j] == 1){
                    visit[i][j] = true;
                    int area = dfs(grid,i,j);
                    maxIsland = Math.max(area,maxIsland);
                }
            }
        }
        return maxIsland;
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    public int dfs(int[][] grid,int i,int j){
        int area = 1;//当前节点面积为1
        for(int k = 0;k < 4;k++){
            int x = dx[k] + i;
            int y = dy[k] + j;
            if(x >=0 && x < m && y >=0 && y < n&& !visit[x][y] && grid[x][y] == 1){
                visit[x][y] = true;
                area += dfs(grid,x,y);//累加
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int [][]grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int result = new Demo3().maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
