import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private boolean [][]visit;
    private int m,n;
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        visit = new boolean[m][n];
        int i = entrance[0],j = entrance[1];
        return bfs(maze,i,j);
    }
    public int bfs(char[][] maze, int i,int j){
        int step = 0;//拓展的层数，从[i,j]到达边界的最短步数
        Queue<int []>q = new LinkedList<>();
        q.add(new int []{i,j});
        visit[i][j] = true;
        while (!q.isEmpty()){
            step++;//进入到新的一层，步数增加
            int size = q.size();//计算当前层
            for(int count = 0;count < size;count++){
                int []tmp = q.poll();
                int a = tmp[0],b = tmp[1];
                for(int k = 0;k < 4;k++){
                    int x = a + dx[k],y = b +dy[k];
                    //找到下一个可以走的路径
                    if(x >= 0 && x < m && y >=0 && y < n&& !visit[x][y] && maze[x][y] == '.'){
                        if(x == 0 || x == m-1 || y == 0 || y == n-1){//遍历到边界(出口)
                            return step;//直接返回，此时一定是最短路径
                        }
                        q.add(new int []{x,y});//不是就继续添加下一层元素
                        visit[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][]maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int []arr = {1,2};
        int ret = new Main().nearestExit(maze,arr);
        System.out.println(ret);
    }
}