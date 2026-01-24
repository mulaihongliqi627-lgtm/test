import java.io.FileInputStream;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int m,n;
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        List<int []>trees = new LinkedList<>();
        //获取树的坐标
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(forest.get(i).get(j) > 1){//是树
                    trees.add(new int []{i,j});
                }
            }
        }
        //规定砍树顺序，从小到大
        Collections.sort(trees, (a, b) ->
        {
            return forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]);
        });
        int bx = 0,by = 0;
        int ret = 0;
        for(int[]tree : trees){
            int a = tree[0],b = tree[1];
            int step = bfs(forest,bx,by,a,b);
            if(step == -1){
                return -1;//走不通
            }
            ret += step;
            bx = a;by = b;
        }
        return ret;
    }
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    //从[x,y]到[a,b]之间的最短路径
    public int bfs(List<List<Integer>> f,int x,int y,int a,int b){
        if(x == a && y == b){
            return 0;//起始和终止重合
        }
        Queue<int []> q = new LinkedList<>();
        boolean[][]vis = new boolean[m][n];
        q.add(new int []{x,y});
        vis[x][y] = true;
        int step = 0;
        while (!q.isEmpty()){
            step++;
            int sz = q.size();
            while (sz-- > 0){
                int []tmp = q.poll();
                int i = tmp[0],j = tmp[1];
                for(int k = 0;k < 4;k++){
                    int ex = dx[k] + i;
                    int ey = dy[k] + j;
                    if(ex >= 0 && ex < m && ey >= 0 && ey < n && !vis[ex][ey] && f.get(ex).get(ey) >= 1){
                        if(ex == a && ey == b){//到达目的坐标
                            return step;
                        }
                        q.add(new int []{ex,ey});
                        vis[ex][ey] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FileInputStream fileInputStream = new FileInputStream();
    }
}