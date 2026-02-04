import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Demo1 {
    public int maxDistance(int[][] grid) {
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};
        int m = grid.length,n = grid[0].length;
        int [][]dist = new int [m][n];
        for(int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                dist[i][j] = -1;
            }
        }
        Queue<int []> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new int []{i,j});
                }
            }
        }
        int max = 0;
        //此时队列中存储着全部的海洋坐标
        while (!q.isEmpty()){
            int []tmp = q.poll();
            int a = tmp[0],b = tmp[1];
            for(int k = 0;k < 4;k++){
                int x = dx[k] + a,y = dy[k] + b;
                if(x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1){
                    dist[x][y] = dist[a][b] + 1;//相邻坐标直接的曼哈顿距离为1
                    max = Math.max(0,dist[x][y]);
                    q.add(new int []{x,y});
                }
            }
        }
        return (max == 0) ? -1 : max;
    }
}
