import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<String> list;
    private static StringBuilder path;
    private static String[]ret = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static int pos  = 0;

    public static List<String> letterCombinations(String digits) {
        list = new LinkedList<>();
        path = new StringBuilder();
//        int start = digits.charAt(0) - '0';//获取digital起始的数字
        dfs(digits,0);
        return list;
    }
    public static void dfs(String digits,int pos){
        if(path.length() == digits.length()){
            list.add(path.toString());
            return;
        }
        int num = digits.charAt(pos) - '0';
        String s = ret[num];
        for(int i = 0;i < s.length();i++){
            path.append(s.charAt(i));
            dfs(digits,pos+1);
            path.deleteCharAt(path.length() - 1);//恢复现场
        }
    }
    public static void main(String[] args) {
        String digits = "22";
        List<String> arr = letterCombinations(digits);
        System.out.println(arr);
    }
}