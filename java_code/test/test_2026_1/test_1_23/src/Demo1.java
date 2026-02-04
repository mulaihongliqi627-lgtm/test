import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo1 {
    private int []dx = {0,0,1,-1};
    private int []dy = {1,-1,0,0};
    private boolean[][]vis;
    private int m,n,count;
    public int cutOffTree(List<List<Integer>> forest) {
        int [][]arr = (int [][])forest.toArray();
        m = arr.length;n = arr[0].length;
        vis = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(arr[i][j] == 0){
                    count++;//计算原数组障碍物的个数
                }
            }
        }
        return bfs(arr,0,0);
    }
    public int bfs(int [][]arr,int i,int j){
        Queue<int []> q = new LinkedList<>();
        q.add(new int []{i,j});
        vis[i][j] = true;
        int step = 0;
        while (!q.isEmpty()){
            step++;
            int sz = q.size();
            while (sz-- > 0){
                int []tmp = q.poll();
                int a = tmp[0],b = tmp[1];
                for(int k = 0;k < 4;k++){
                    int x = dx[k] + a;
                    int y = dy[k] + b;
                    if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && arr[x][y] >= 1){
                        q.add(new int []{x,y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}
