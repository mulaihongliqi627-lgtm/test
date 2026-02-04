import java.util.*;

public class demo2 {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<>();
        for(int x : nums){
            hash.put(x,hash.getOrDefault(x,0) + 1);
            if(hash.get(x) >= 2){//有重复元素
                return true;
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();//存放元素和对应数组下标
        for(int i = 0;i < nums.length;i++){
            if(hash.containsKey(nums[i])){
                int len = Math.abs(i - hash.get(nums[i]));
                if(len <= k){
                    return true;
                }
            }
            hash.put(nums[i],i);
        }
        return false;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hash = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);//把字母按ASCII码值排序
            String str1 = new String(charArray);//把字符数组转化为字符串
            if(!hash.containsKey(str1)){
                hash.get(str1).add(str);
            }else{
                hash.put(str1,new ArrayList());
            }
        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        String []strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<>
        System.out.println(result);
    }
}
