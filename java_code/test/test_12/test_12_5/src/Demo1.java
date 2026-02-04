import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo1 {
    private static int ret = 0;
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []arr = new int[5];
        for(int i = 0;i < 5;i++){
            arr[i] = sc.nextInt();
            if(check(arr[i])){
                ret++;
            }
        }
        System.out.println(ret);
    }
    public static boolean check(int x){
        if((x % 10 - (x/100) % 10  == 1) && ((x / 1000) == (x/10)%10)){
            return true;
        }
        return false;
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        char []arr1 = s1.toCharArray();
        char []arr2 = s2.toCharArray();
        int len1 = s1.length(),len2 = s2.length();
        Map<Character,Integer> hash2 = new HashMap<>();
        for(int i = 0;i < len2;i ++){
            char ch = arr2[i];
        }
        int []dp = new int[len1 + 1];
        for(int i = 1;i < len1;i++){
        }
    }
}
