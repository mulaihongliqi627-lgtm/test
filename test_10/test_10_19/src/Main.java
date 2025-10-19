import java.util.*;

public class Main {
    public static int totalFruit(int[] fruits) {
        int len = fruits.length,count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int left =0,right = 0;right < len;right++){
            int in = fruits[right];
            map.put(in,map.getOrDefault(in,0)+1);//进窗口
            if(map.size() > 2){//水果种类超过二,出窗口
                int out = fruits[left];
                map.put(out,map.get(out)-1);
                if(map.get(out) == 0){//该类型水果已全部出篮
                    map.remove(out);
                }
                left++;
            }
            count = Math.max(count,right-left+1);//更新结果
        }
        return count;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        int count = 0; // 用于统计窗口中有效字符个数

        for (int i = 0; i < p.length(); i++) {
            hash2[p.charAt(i) - 'a']++;
        }

        for (int left = 0, right = 0; right < s.length(); right++) {
            hash1[s.charAt(right) - 'a']++; // 进窗口

            if (hash1[s.charAt(right) - 'a'] <= hash2[s.charAt(right) - 'a']) {
                count++;
            }

            // 先判断是否满足异位词条件（窗口大小正好等于p的长度）
            if (right - left + 1 == p.length()) {
                if (count == p.length()) {
                    list.add(left);
                }
            }

            // 然后判断是否需要出窗口
            if (right - left + 1 > p.length()) {
                hash1[s.charAt(left) - 'a']--;
                if (hash1[s.charAt(left) - 'a'] < hash2[s.charAt(left) - 'a']) {
                    count--;
                }
                left++;
            }
        }
        return list;
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer>map2 = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        int len1 = words.length;
        int len2 = words[0].length();
        for(int i = 0;i < len1;i++){
            String in = words[i];
            map2.put(in,map2.getOrDefault(in,0)+1);
        }
        for(int i = 0;i < len2;i++){
            Map<String,Integer>map1 = new HashMap<>();
            for(int left = i,right = i,count = 0;right+len2 <= s.length();right+=len2){
                String in = s.substring(right,right+len2);
                map1.put(in,map1.getOrDefault(in,0)+1);//进窗口
                if(map1.get(in) <= map2.getOrDefault(in,0)) {
                    count++;//进窗口字符串为有效字符串
                }
                if(right-left+1 > len1*len2){//出窗口
                    String out = s.substring(left,left+len2);
                    map1.put(out,map1.get(out)-1);
                    if(map1.get(out) < map2.getOrDefault(out,0)){//删掉的是有效字符串
                        count--;
                    }
                    left+=len2;
                }
                if(count == len1){//判断是否构成异位字符串
                    list.add(left);//记录异位字符串的起始索引
                }
            }
        }
        return list;
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int len = Integer.MAX_VALUE,index = 0;
        String str = "";
        if(s.length() < t.length()){
            return str;
        }
        for(int i = 0;i < t.length();i++){
            Character in = t.charAt(i);
            map2.put(in,map2.getOrDefault(in,0)+1);
        }
        for(int left = 0,right = 0,count = 0;right < s.length();right++){
            Character in = s.charAt(right);
            map1.put(in,map1.getOrDefault(in,0)+1);//进窗口
            if(map1.get(in) <= map2.getOrDefault(in,0)){
                count++;
            }
            while(count == t.length()){//判断窗口合法时出窗口
                if(right-left+1 < len){//更新结果
                    index = left;
                    len = Math.min(len,right-left+1);
                    str = s.substring(index,index+len);
                }
                Character out = s.charAt(left);
                if(map1.get(out) <= map2.getOrDefault(out,0)){
                    count--;
                }
                map1.put(out,map1.get(out)-1);
                left++;
            }
        }
        return str;
    }
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid_index = left+(right - left)/2;
            int mid = nums[mid_index];
            if(mid < target){//target在mid右边,左边区域舍去
                left = mid_index+1;
            }else if(mid > target){//target在mid左边,右边区域舍去
                right = mid_index-1;
            }else{
                return mid_index;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int []nums = {-1,0,3,5,9,12};
        int result = search(nums,2);
        System.out.println(result);
    }
}