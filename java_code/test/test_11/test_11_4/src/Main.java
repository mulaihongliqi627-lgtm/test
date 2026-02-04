import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String convert(String s, int n) {
        String str = "";
        int d = 2*n-2;
        if(d == 0){
            return s;
        }
        for(int i = 0; i < n;i++){
            int x = i;
            if(i == 0 || i == n-1){
                while(x < s.length()){
                    str += s.charAt(x);
                    x += d;
                }
            }else{
                int y = d - x;
                while(x < s.length() || y < s.length()){
                    str += s.charAt(x);
                    if(y < s.length()){//走到这里x下标一定不会越界，但是y下标可能越界
                        str += s.charAt(y);
                    }
                    x += d;
                    y += d;
                }
            }

        }
        return str;
    }
    public static int minNumberOfFrogs(String croakOfFrogs) {
        String s = "croak";
        int n = s.length();
        int []hash = new int[n];//记录“croak”
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < hash.length;i++){
            map.put(s.charAt(i),i);//存储croak每一个字母对应的下标
        }
        char []croak = croakOfFrogs.toCharArray();
        for(char ch : croak){
            if(ch == 'c'){
                if(hash[n-1] > 0){//又开始了一个叫声，但此时有其他青蛙完成了一次蛙叫，可以把完成蛙叫的青蛙再次分配蛙叫
                    hash[n-1]--;//分配蛙叫
                }
                hash[0]++;
            }else{
                int index = map.get(ch);
                if(hash[index-1] == 0){
                    return -1;//说明给定字符不是由有效蛙鸣字符构成
                } else{
                    hash[index-1]--;//前一个字符对应的hash值--，该位置hash值++
                    hash[index]++;
                }
            }
        }
        for(int i = 0;i < 4;i++){//查看给定字符是否是由合法蛙叫字符构成，如果不是，完成上面循环后前四位仍然有hash值
            if(hash[i] != 0){
                return -1;
            }
        }
        return hash[n-1];
    }

    interface SumNumber{
        int sum(int a,int b);
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        SumNumber add = (a,b)->{return a+b;};
        int sum = add.sum(a,b);
        System.out.println("a + b = " + a);

    }
}
