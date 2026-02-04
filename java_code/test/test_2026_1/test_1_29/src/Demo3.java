import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo3 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character,Integer> in = new HashMap<>();
        for(int i= 0;i <words.length;i++){
            for(int j = 0;j < words[i].length();j++){
                in.put(words[i].charAt(j),0);//把所有的字符全部初始化为入度为0
            }
        }
        for(int i= 0 ;i < words.length;i++){
            String ch1 = words[i];
            for(int j = i + 1;j < words.length;j++){
                String ch2 = words[j];
                for(int m = 0;m < ch1.length();m++){
                    for (int n = 0;n < ch2.length();n++){
                        if(ch1.charAt(m) != ch2.charAt(n)){//说明ch1对应的字符字典序在ch2对应的字符之前
                            //建图
                            if(!edges.containsKey(ch1.charAt(m))){
                                edges.put(ch1.charAt(m),new HashSet<>());//不存在就new出hash，作为字典顺序大小依据
                            }
                            edges.get(ch1.charAt(m)).add(ch2.charAt(n));
                        }
                    }
                    if(m < ch1.length()){//说明ch1和ch2长度不同，但是前面的字符相同，例如abc 和 ab
                        return " ";
                    }
                }
            }
        }
    }
}
