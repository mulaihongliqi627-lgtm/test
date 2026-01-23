import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//单词接龙
public class Main {
    private Set<String>vis = new HashSet<>();//标记已经变化的字符
    private Set<String>hash = new HashSet<>();//字符库哈希表
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String s : wordList){
            hash.add(s);
        }
        if(!hash.contains(endWord)) return 0;//无法转变
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vis.add(beginWord);
        int step = 1;//字符变化需要的步数
        while (!q.isEmpty()){
            step++;//一进入新的一层，代表一个字符的变化操作
            int sz = q.size();//计算目前队列该层元素个数
            while (sz-- > 0){
                String tmp = q.poll();//弹出队列顶元素
                for(int i = 0;i < beginWord.length();i++){
                    char[]t = tmp.toCharArray();//转为字符数组便于修改操作
                    for(int j = 0;j < 26;j++){//枚举26位字母尝试转化
                        char ch = (char) (j + 97);//转为小写字母
                        t[i] = ch;
                        String next = new String(t);//重新转化为字符串
                        if(next.equals(endWord)) return step;//变化成功,返回步长
                        if(hash.contains(next) && !vis.contains(next)){//在字符哈希库中，是首次出现
                            vis.add(next);
                            q.add(next);//队列中添加变化后的结果字符
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}