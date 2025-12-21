import java.lang.reflect.Array;

public class Demo1 {
    int m,n;
    private char[]word;
    private boolean[][]visit;
    public boolean exist(char[][] board, String _word) {
        m = board.length;
        n = board[0].length;
        word = _word.toCharArray();
        visit = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == word[0]){
                    visit[i][j] = true;
                    //以该位置,去四周找下一个字符
                    if(dfs(board,i,j,1) == true) return true;
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }
    //向量数组
    int[]dx = {0,0,1,-1};
    int []dy = {-1,1,0,0};
    public boolean dfs(char[][] board,int i,int j,int pos){
        if(pos == word.length){
            return true;
        }
        for(int k = 0;k < 4;k++){
            //利用向量数组计算坐标偏移量
            int x = i + dx[k],y = j + dy[k];
            //不越界，未被使用，字符匹配
            if(x >=0 && x < m && y >=0 && y < n && !visit[x][y] && board[x][y] == word[pos]){
                visit[x][y] = true;
                if(dfs(board,x,y,pos+1)) return true;
                visit[x][y] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
