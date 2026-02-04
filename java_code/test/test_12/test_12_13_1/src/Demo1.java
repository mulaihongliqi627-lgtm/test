import java.util.LinkedList;
import java.util.List;

public class Demo1 {
    private static List<String> list;
    private static StringBuilder path;
    private static int x,left,right;
    public static List<String> generateParenthesis(int n) {
        list = new LinkedList<>();
        path = new StringBuilder();
        x = n;
        dfs();
        return list;
    }
    public static void dfs(){
        if(path.length() == 2 * x){
            list.add(path.toString());
            return;
        }
        if(left < x){
            path.append('(');
            left++;
            dfs();
            path.deleteCharAt(path.length() - 1);
            left--;
        }
        if(right < left){
            path.append(')');
            right++;
            dfs();
            path.deleteCharAt(path.length() - 1);
            right--;
        }
    }
    public static void main(String[] args) {
        List<String> s = generateParenthesis(4);
        System.out.println(s);
    }
}
