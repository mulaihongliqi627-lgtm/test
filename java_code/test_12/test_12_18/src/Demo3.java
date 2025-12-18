import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo3 {
    private boolean[][] visited;
    private List<List<String>> list;
    private List<String> path;
//    private int pos;
    public List<List<String>> solveNQueens(int n) {
        visited = new boolean[n][n];
        list = new LinkedList<>();
        path = new LinkedList<>();
        dfs(n,0);
        return list;
    }
    public void dfs(int n,int pos){

        for(int i = pos;i < n;i++){
            for (int  j = 0;j < n;j++){
                if(visited[i][j] == false){//没被使用
                    visited[i][j] = true;
                    if(check(i,j,visited)){//不会被攻击
                        path.add("Q");
                        dfs(n,pos+1);
                        list.remove(list.size()-1);

                    }else{

                    }


                }else{

                }
            }
            list.add(new ArrayList<>(path));
        }
    }
    //检查当前位置是否可以不会被其他皇后攻击
    public boolean check(int i,int j,boolean[][]visited){
        for(int x = 0;i < visited.length;x++){
            if(x!= i && visited[x][j] == true){//出现在其他皇后的攻击范围内
                return false;//当前位置不能放置皇后
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
