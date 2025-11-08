import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a<=0||b<=0||a>100000||b>100000){
            return;
        }
        int result = (a*b)/num(a,b);
        System.out.println(result);
    }
    public static int num(int a,int b){
        while(b> 0){
            int x = a%b;
            a = b;
            b = x;
        }
        return a;
    }
    public static int totalFruit(int[] f) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = f.length;
        int count = 0;
        for(int left = 0,right = 0;right < n;right++){
            //不存在就让map中f[right]种类水果数目增加1
            map.put(f[right],map.getOrDefault(f[right],0)+1);
            while(map.size() > 2){//摘到了第三种水果
                map.put(f[left],map.get(f[left])-1);//让对应水果数目减一
                if(map.get(f[left]) == 0){//对应水果数目减少到0时
                    map.remove(f[left]);//删除对应水果种类
                }
                left++;
            }
            count = Math.max(count,right-left+1);
        }
        return count;
    }

    public static void main3(String[] args) {
        int[]arr = {1,1,1};
        int result = MLS(arr);
        System.out.println(result);
    }
    public static int MLS (int[] arr) {
        Arrays.sort(arr);
        int left = 0,right = 0,len = 0,n = arr.length;
        while(right < n){
           if(right > 0 && arr[right]-1 != arr[right-1]){//不连续
               left = right;
           }
           len = Math.max(len,right-left+1);
           right++;
        }
        return len;
    }
    public static List<Integer> findAnagrams2(String s, String p) {
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
            if (right - left + 1 >= p.length()) {
                hash1[s.charAt(left) - 'a']--;
                if (hash1[s.charAt(left) - 'a'] < hash2[s.charAt(left) - 'a']) {
                    count--;
                }
                left++;
            }
        }
        return list;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer>list = new LinkedList<>();
        if(s.length() < p.length()){
            return list;
        }
        int left = 0;
        int right = left+p.length()-1;
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            map2.put(p.charAt(i),map2.getOrDefault(p.charAt(i),0)+1);
        }
        while(right < s.length()){
            if(isAnagrams(left,right,s,map2)){//判断窗口中的字符是否是异位字符串
                list.add(left);
            }
            left++;
            right++;
        }
        return list;
    }
    public static Boolean isAnagrams(int left,int right,String s,Map<Character,Integer> map2){
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i = left;i <= right;i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        if(map1.equals(map2)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer>list = findAnagrams2(s,p);
        System.out.println(list);
    }
}