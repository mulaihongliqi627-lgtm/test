import java.util.LinkedList;
import java.util.List;

public class Demo4 {
    private List<String> list;
    private StringBuilder sb;
    public List<String> letterCasePermutation(String s) {
        list = new LinkedList<>();
        sb = new StringBuilder();
        dfs(s,0);
        return list;
    }
    public void dfs(String s,int pos){
        if(sb.length() == s.length()){
            list.add(sb.toString());
            return;
        }
        char ch = s.charAt(pos);
        if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
            sb.append(Character.toLowerCase(ch));
            dfs(s,pos+1);
            sb.deleteCharAt(sb.length()-1);//恢复现场
        }
        if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z'){
            sb.append(Character.toUpperCase(ch));
            dfs(s,pos+1);
            sb.deleteCharAt(sb.length()-1);//恢复现场
        }else{
            sb.append(ch);
            dfs(s,pos+1);
            sb.deleteCharAt(sb.length()-1);//恢复现场
        }

    }
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> ret = new Demo4().letterCasePermutation(s);
        System.out.println(ret);
    }
}
