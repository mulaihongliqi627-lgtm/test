import java.util.LinkedList;
import java.util.Queue;

public class Demo1 {
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public int numEnclaves(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean[][]vis = new boolean[m][n];
        Queue<int []> q = new LinkedList<>();
        //正难则反，以边界的1为起点，向外拓展，把能拓展到的1标记，剩余的未标记1的个数即为所求
        for(int i = 0;i < n;i++){
            if(grid[0][i] == 1){//第一行
                q.add(new int[] {0,i});
                vis[0][i] = true;
            }
            if(grid[m-1][i] == 1){//最后一行
                q.add(new int []{m-1,i});
                vis[m-1][i] = true;
            }
        }
        for(int j = 0;j < m;j++){
            if(grid[j][0] == 1){
                q.add(new int []{j,0});
                vis[j][0] = true;
            }
            if(grid[j][n-1] == 1){
                q.add(new int []{j,n-1});
                vis[j][n-1] = true;
            }
        }
        while (!q.isEmpty()){
            int []tmp = q.poll();
            int a = tmp[0],b = tmp[1];
            for(int k = 0;k < 4;k++){
                int x = dx[k] + a,y = dy[k] + b;
                if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1){
                    vis[x][y] = true;
                    q.add(new int []{x,y});
                }
            }
        }
        int count = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1 && !vis[i][j]){//是1,但是没被标记，为飞地
                    count++;
                }
            }
        }
        return count;
    }
}
