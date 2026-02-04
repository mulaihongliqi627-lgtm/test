//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int count,m,n;
    private int [][]arr;
    private boolean[][]visit;
    private int base;
    public int wardrobeFinishing(int x, int y, int cnt) {
        m = x;n = y;
        arr = new int[m][n];
        visit = new boolean[m][n];
        base = cnt;
        dfs(0,0);
        return count;
    }
    int []dx = {1,0};
    int []dy = {0,1};
    public void dfs(int i,int j){
        count++;
        visit[i][j] = true;//标记为已访问，防止相邻元素反复横跳来回递归
        for(int k = 0;k < 2;k++){
            int x = i + dx[k],y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && !visit[x][y] && (sum(x) + sum(y)) <= base){
                dfs(x,y);
            }
        }
    }
    //计算坐标的位数之和
    public int sum(int n){
        int s = 0;
        while (n > 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public static void main(String[] args) {
        int ret = new Main().wardrobeFinishing(4,7,5);
        System.out.println(ret);
//        int x = new Main().sum(52);
//        System.out.println(x);
    }
}