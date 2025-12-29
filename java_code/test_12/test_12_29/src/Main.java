//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int m,n;
    private boolean[][]visit;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        if(board[click[0]][click[1]] == 'M'){//起始扫雷位置是地雷，直接结束游戏
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board,click[0],click[1]);
        return board;
    }
    int []dx = {0,0,1,1,1,-1,-1,-1};
    int []dy = {1,-1,0,-1,1,0,-1,1};
    public void dfs(char[][] board,int i,int j){
        visit[i][j] = true;
        int count = 0;//地雷的个数

        //计算点击位置的四周的地雷个数
        for(int k = 0;k < 8;k++){
            int x = i + dx[k];int y = j + dy[k];
            if(x >=0 && x < m&& y >=0 && y < n && !visit[x][y] && board[x][y] == 'M'){//是地雷
                count++;
            }
        }
        //四周没找到地雷，继续递归
        if(count == 0){
            board[i][j] = 'B';//标记为已经挖过的非地雷区域，且四周无雷
            for(int k = 0;k < 8;k++){
                int x = i + dx[k];int y = j + dy[k];
                if(x >=0 && x < m&& y >=0 && y < n && !visit[x][y] && board[x][y] == 'E'){
                    dfs(board,x,y);//继续探索
                }
            }
        }else{//四周有雷的话就在当前位置标记四周地雷个数
            board[i][j] = (char)(count + '0');
            return;//返回上一层
        }
    }
    public static void main(String[] args) {

    }
}