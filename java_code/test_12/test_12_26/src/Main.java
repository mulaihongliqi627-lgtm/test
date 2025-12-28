import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int m,n;
    private boolean[][]visit;
    public void solve(char[][] board) {
        m = board.length;n = board[0].length;
        visit = new boolean[m][n];
        //修改边界的O的连通块
        for(int j = 0;j < n;j++){
            if(board[0][j] == 'O'){//第一行
                dfs(board,0,j);
            }
            if(board[m-1][j] == 'O'){//最下面一行
                dfs(board,m-1,j);
            }
        }
        for(int i = 0;i < m;i++){
            if(board[i][0] == 'O'){//第一列
                dfs(board,i,0);
            }
            if(board[i][n-1] == 'O'){//最后一列
                dfs(board,i,n-1);
            }
        }
        //复原，'.'为没有被封闭的联通块，无需修改为O，其余的遇到'O'就代表封闭，直接修改为'X'
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == '.') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    public void dfs(char[][] board,int i,int j){
        board[i][j] = '.';//做个标记，标记不需要修改的联通块
        for(int k = 0;k < 4;k++){
            int x = dx[k] + i,y = j + dy[k];
            if(x >=0 && x < m && y >=0 && y < n && !visit[x][y] && board[x][y] == 'O'){
                visit[x][y] = true;
                dfs(board,x,y);
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                        {'X','O','X','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};
        new Main().solve(board);
        for(char[]row : board){
            System.out.println(Arrays.toString(row));
        }

    }
}