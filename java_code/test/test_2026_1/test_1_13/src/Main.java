import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//public class Main {
//
//    public static void main1(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        if(isString(s) == true){
//            System.out.println("yes");
//        }else {
//            System.out.println("no");
//        }
//
//
//    }
//    public static boolean isString(String s){
//        int j = s.length() - 1,i = 0;
//        while (i < j){
//            if(s.charAt(i) != s.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//}
//public class Main {
//    public static void main(String []args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String s = sc.next();
//        int n = s.length();
//        int ret = 0;
//        for(int i = 0;i < str.length();i++){
//            if(i + n < str.length()){
//                String tmp = str.substring(i,i+n);
//                if(tmp.equals(s)){
//                    ret++;
//                }
//            }
//        }
//        System.out.println(ret);
//    }
//}
//public class Main {
//    public static void main(String[]args){
//        List<Integer> list = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i = 0;i < n;i++){
//            int num = sc.nextInt();
//            list.add(num);
//        }
//        int k = sc.nextInt();//删除的次数
//        while(k > 0){
//            int index = sc.nextInt();//删除下标
//            list.remove(index);
//            k--;
//        }
//        for(int i = 0;i < list.size();i++){
//            System.out.print(list.get(i));
//            if(i != list.size() - 1){
//                System.out.print(" ");
//            }
//        }
//    }
//}
public class Main {
    public static void main(String[] args) {
        int num = rNum(700);
        System.out.println(num);
    }
    public static int rNum(int num){
        int ret = 0;//num的位数
        int []arr = new int [1000000];
        int k = 0;
        while(num > 0){
            arr[k++] = num % 10;
            num /= 10;
            ret++;
        }
        int sum = 0;
        for(int i = 0;i < k;i++){
            int x = (int)Math.pow(10,ret-1) * arr[i];
            ret--;
            sum += x;
        }
        return sum;
    }
}