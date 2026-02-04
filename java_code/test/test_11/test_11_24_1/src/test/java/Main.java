import java.util.Scanner;

public class Main {
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int []hash = new int[26];
        char[]arr = s1.toCharArray();
        char[]arr2 = s2.toCharArray();
        //把s1的每一个字符加入hash表中
        for(char ch : arr){
            int x = ch - 'a';
            hash[x]++;
        }
        for(char ch2 : arr2){
            int y = ch2 - 'a';
            if(--hash[y]  < 0){
                return false;//说明该字符是是新字符或者s2对应字符大于s1的对应该字符个数
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bad";
        boolean result =  CheckPermutation(s1,s2);
        System.out.println(result);
    }
}
