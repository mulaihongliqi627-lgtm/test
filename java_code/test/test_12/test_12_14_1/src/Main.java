import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<List<Integer>> list;
    private static List<Integer> path;
    private static int n,l;

    public static List<List<Integer>> combine(int x, int k) {
        list = new LinkedList<>();
        path = new LinkedList<>();
        l = k;n = x;
        dfs(1);
        return list;
    }
    public static void dfs(int start){
        if(path.size() == l){
            list.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i <= n;i++){
            path.add(i);
            dfs(i+1);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ret = combine(4,2);
        System.out.println(ret);
    }
}