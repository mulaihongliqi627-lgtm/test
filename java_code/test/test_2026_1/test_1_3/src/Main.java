//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int []arr;
    public int fib(int n) {
        arr = new int[31];
        for(int i = 0;i < 31;i++){//初始化arr数组
            arr[i] = -1;
        }
        return dfs(n);
    }
    public int dfs(int n){
        if(arr[n] != -1){//之前已经计算过了
            return arr[n];
        }
        if(n == 0 || n == 1) {
            arr[n] = n;
            return arr[n];
        }
        arr[n] = dfs(n - 1) + dfs(n-2);
        return arr[n];
    }
    public static void main(String[] args) {

    }
}