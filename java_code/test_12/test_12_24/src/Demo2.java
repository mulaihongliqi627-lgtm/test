public class Demo2 {
    private int m,n;
    private boolean[][]visit;
    private int count;
    public int numIslands(char[][] grid) {
        count = 0;
        m = grid.length;n = grid[0].length;
        visit = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(!visit[i][j]&&grid[i][j] == '1'){//找到岛屿
                    visit[i][j] = true;
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public void dfs(char [][]grid,int i,int j){
        for(int k = 0;k < 4;k++){
            int x = dx[k] + i,y = dy[k] + j;
            //越界检查，无需回溯
            if(x >= 0 && x < m&& y >=0 && y < n&&!visit[x][y] && grid[x][y] == '1'){
                visit[x][y] = true;
                dfs(grid,x,y);
            }
        }
    }

    public static void main(String[] args) {
        char[][]gird = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = new Demo2().numIslands(gird);
        System.out.println(result);
    }
}
