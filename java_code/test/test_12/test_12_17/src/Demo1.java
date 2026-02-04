public class Demo1 {
    private int sum;
    private boolean check[];
    private int pos;
    public int countArrangement(int n) {
        sum = 0;
        pos = 0;
        check = new boolean[n + 1];
        dfs(n,pos);
        return sum;
    }
    public void dfs(int n,int pos){
        if(pos == n){//合法,计数,不是和n-1比较是dfs递归时传的是pos+1的值
            sum++;
            return;
        }
        for(int i = 1;i <= n;i++){
            if(check[i] == false && (i % (pos +1) == 0 || (pos + 1) % i == 0)){
                check[i] = true;
                dfs(n,pos+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int result = new Demo1().countArrangement(n);
        System.out.println(result);
    }
}
