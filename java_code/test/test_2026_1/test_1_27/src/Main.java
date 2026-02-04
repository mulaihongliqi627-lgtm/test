import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int []dx = {1,-1,0,0};
    private int []dy = {0,0,1,-1};
    public int[][] highestPeak(int[][] arr) {
        int m = arr.length,n = arr[0].length;
        int [][]dist = new int[m][n];
        for(int i = 0;i < m;i++){//初始化
            for(int j = 0;j < n;j++){
                dist[i][j] = -1;
            }
        }
        Queue<int []> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(arr[i][j] == 1){//原数组找到水域
                    dist[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        while (!q.isEmpty()){//队列中记录着dist数组中的水域坐标
            int []tmp = q.poll();
            int a = tmp[0],b = tmp[1];
            for(int k = 0;k < 4;k++){
                int x = a + dx[k],y = b + dy[k];
                if(x >= 0 && x < m && y >= 0 && y < n && dist[x][y] == -1 && arr[x][y] == 0){
                    dist[x][y] = dist[a][b] + 1;
                    q.add(new int []{x,y});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {

    }
}