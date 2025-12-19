public class Demo1 {
    //暴力解法
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i <9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if(check(board,i,j,num)){//出现过
                         return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check(char[][] board,int m,int n,int num){
        for(int j = 0;j < 9;j++){//num所处行出现过该数字
            if(j != n && board[m][j]-'0' == num){
                return true;
            }
        }
        for(int i = 0;i < 9;i++){//num所处列出现过该数字
            if(i != m && board[i][n]-'0' == num){
                return true;
            }
        }
        int startRow = (m/3)*3;
        int startCol = (n/3)*3;
        for(int i = startRow;i < m + 3;i++){//num所处九宫格内出现过该数字
            for (int j = startCol;j < n + 3;j++){
                if((i < 9 && j < 9)&&(i != m && j != n) && board[i][j] - '0' == num){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
