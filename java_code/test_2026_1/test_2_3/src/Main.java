import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private Map<Character, Set<Character>> edges = new HashMap<>();//set集合存储和key值的出度边相连的字符
    private Map<Character,Integer> in = new HashMap<>();
    private  boolean check;
    public String alienOrder(String[] words) {
        int n = words.length;
        for(int i = 0;i < n;i++){
            String str = words[i];
            for(int j =0 ;j < str.length();j++){
                in.put(str.charAt(j),0);
            }
        }
        for(int i = 0;i < n;i++){
            for (int j = i + 1;j < n;j++){
                add(words[i],words[j]);
                if(check == true) return "";
            }
        }

        //拓扑排序
        Queue<Character> q = new LinkedList<>();
        for(char ch : in.keySet()){
            if(in.get(ch) == 0){
                q.add(ch);
            }
        }
        //度0节点添加到结果集，并把出度相邻边的节点入度减1
        StringBuilder ret = new StringBuilder();
        while (!q.isEmpty()){
            char tmp = q.poll();
            ret.append(tmp);//添加结果
            if(!edges.containsKey(tmp)){
                continue;
            }
            //减in里的度
            for(char ch : edges.get(tmp)){
                in.put(ch,in.get(ch) - 1);
                if(in.get(ch) == 0){//把减度后入度为0的节点添加到队列
                    q.add(ch);
                }
            }
        }
        for(char ch : in.keySet()){
            if(in.get(ch) != 0){
                return "";
            }
        }
        return ret.toString();
    }
    //找到两个字符串第一个不相同的字典序
    public void add(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        int i = 0;
        while (i < len){
            char ch1 = s1.charAt(i),ch2 = s2.charAt(i);
            if (ch1 != ch2){
                //此时ch1 ！= ch2,字典序判断
                if(!edges.containsKey(ch1)){//不存在就添加set集合，
                    edges.put(ch1,new HashSet<>());
                }
                if(!edges.get(ch1).contains(ch2)){//字典序先后得出
                    edges.get(ch1).add(ch2);
                    in.put(ch2,in.get(ch2) + 1);//ch2的入度值加1
                }
                break;//只处理初次遇到一对不相同的字符，舍去后续遍历
            }
            i++;
        }
        if(i == s2.length() && i < s1.length()){
            check = true;//必定不合法
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}