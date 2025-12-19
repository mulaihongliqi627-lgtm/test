//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private boolean [][]row ,col;
    private boolean[][][] grid;
    public boolean isValidSudoku(char[][] board) {
        row = new boolean[9][10];//判断某一行的某个数字是否出现过，比如row[4][2] = true,就是第四行中2这个数字出现过
        col = new boolean[9][10];
        grid = new boolean[3][3][10];
        for(int i = 0;i <9;i++){
            for (int j = 0;j <9;j++){
                if(board[i][j] != '.'){//是数字时
                    int num = board[i][j] - '0';
                    //判断这个位置的数字是否是有效的
                    if(row[i][num] || col[j][num] || grid[i / 3][j / 3][num]){//任意一种方式出现 都不合法
                        return false;
                    }
                    row[i][num] = col[j][num] = grid[i / 3][j / 3][num] = true;//标记已出现
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}