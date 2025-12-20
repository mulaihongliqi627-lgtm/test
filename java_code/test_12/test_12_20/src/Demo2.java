public class Demo2 {
    private boolean checkRow [][];
    private boolean checkCol [][];
    private boolean checkGrid[][][];
    public void solveSudoku(char[][] board) {
        checkRow = new boolean[9][10];
        checkCol = new boolean[9][10];
        checkGrid = new boolean[3][3][10];
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                char ch = board[i][j];
                if(ch != '.'){//该位置原board数组上是数字字符
                    int num = board[i][j] - '0';
                    checkRow[i][num] = checkCol[j][num] = checkGrid[i/3][j/3][num] = true;
                    dfs(board);
                }
            }
        }
    }
    public boolean dfs(char[][]board){//判断这个数独是否合法
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.'){//填空
                    for(int num = 1;num <= 9;num++){
                        //都没出现过
                        if(!checkRow[i][num] && !checkCol[j][num] && !checkGrid[i/3][j/3][num]){
                            board[i][j] = (char)(num + '0');//填写
                            checkRow[i][num] = checkCol[j][num] = checkGrid[i/3][j/3][num] = true;
                            if(dfs(board) == true) return true;//下一层也能正常填
                            //填了这个位置，下个位置填不了,恢复现场
                            board[i][j] = '.';
                            checkRow[i][num] = checkCol[j][num] = checkGrid[i/3][j/3][num] = false;
                        }
                    }
                    return false;//1-9尝试完了都填不了
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }
}
