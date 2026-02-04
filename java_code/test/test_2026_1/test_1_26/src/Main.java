import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int m,n;
    private boolean[][]vis;
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;n = mat[0].length;
        vis = new boolean[m][n];
        int [][]dist = new int[m][n];
        Queue<int []> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0){//把0当做一个大的整体起点，预处理
                    q.add(new int []{i,j});
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            step++;
            while (sz-- > 0){
                int []tmp = q.poll();
                int a = tmp[0],b = tmp[1];
                for(int i = 0;i < 4;i++){
                    int x = dx[i] + a,y = dy[i] + b;
                    if(x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && mat[x][y] == 1){
                        q.add(new int []{x,y});
                        vis[x][y] = true;
                        dist[x][y] = step;
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {

    }
}