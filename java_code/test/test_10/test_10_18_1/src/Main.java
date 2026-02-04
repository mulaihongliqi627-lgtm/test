import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer>list = new LinkedList<>();
        Map<String,Integer> map1 = new HashMap<>();
        for(String str : words){
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        int len1 = words.length;
        int len2 = words[0].length();
        for(int i = 0;i < len2;i++){
            Map<String,Integer> map2 = new HashMap<>();
            for(int left = i,right = i,count = 0;right+len2 < s.length();right+=len2){
                String str = s.substring(right,right+len2);
                map2.put(str,map2.getOrDefault(str,0)+1);//进窗口
                if(map2.get(str) <= map1.getOrDefault(str,0)){//维护count
                    count++;
                }
                if(right - left + 1 > len1*len2){
                    //出窗口
                    String out = s.substring(left,left+len2);
                    if(map2.get(out) <= map1.getOrDefault(out,0)){
                        //说明待删除字符串是有效字符串
                        count--;
                    }
                    map2.put(out,map2.get(out)-1);
                    left+=len2;
                }
                if(count == len1){
                    list.add(left);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[]word = {"foo","bar"};
        List<Integer> list = findSubstring(s,word);
        System.out.println(list);
    }
}