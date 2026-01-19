import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];
        if(prev == color){
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while (!queue.isEmpty()){
            int []tmp = queue.poll();
            int a = tmp[0],b = tmp[1];//得到横纵坐标
            image[a][b] = color;//取队列，把数据修改
            for(int i = 0;i < 4;i++){
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >=0 && x < m && y >= 0 && y < n && image[x][y] == prev){
                    queue.add(new int []{x,y});//找到连通块，入队列
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int [][] ret = new Main().floodFill(image,1,1,2);
        for(int []x : ret){
            System.out.println(Arrays.toString(x));
        }
    }
}