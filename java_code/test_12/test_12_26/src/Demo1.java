import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    private int m,n;
    private List<List<Integer>> ret;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ret = new ArrayList<>();
        m = heights.length;n = heights[0].length;
        boolean[][]visit1 = new boolean[m][n];//可以流向太平洋的坐标
        boolean[][]visit2 = new boolean[m][n];//可以流向大西洋的坐标
        //寻找能通过太平洋边界逆推的坐标
        for(int i = 0;i < n;i++){//遍历第一行
            dfs(heights,0,i,visit1);
        }
        for(int i = 0;i < m;i++){//遍历第一列
            dfs(heights,i,0,visit1);
        }
        //寻找能通过大西洋边界逆推的坐标
        for(int i = m-1;i < n;i++){//遍历矩阵最下面一行
            dfs(heights,m-1,i,visit2);
        }
        for(int i = 0;i < m;i++){//遍历最右边一列
            dfs(heights,i,n-1,visit2);
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(visit1[i][j] == true && visit2[i][j] == true){//改坐标合法，添加结果
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ret.add(list);
                }
            }
        }
        return ret;
    }
    int []dx = {0,0,1,-1};
    int []dy = {1,-1,0,0};
    public void dfs(int[][] heights,int i,int j,boolean[][]visit){
        visit[i][j] = true;
        for(int k = 0;k < 4;k++){
            int x = i + dx[k],y = j +dy[k];//偏移坐标
            if(x >=0 && x < m && y >= 0 && y< n && !visit[x][y] && heights[i][j] <= heights[x][y]){
                dfs(heights,x,y,visit);
            }
        }
    }
}
