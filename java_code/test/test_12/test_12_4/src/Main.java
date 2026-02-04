import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            list.add(i);
        }
        int start = 0,delIndex = 0;
        while (!list.isEmpty()){
            delIndex = (delIndex + m - 1) % list.size();
            int x = list.remove(delIndex);
            arr[x-1] = n-list.size();
        }
        for(int i = 0;i < arr.length ;i++){
            if(i == arr.length - 1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] +",");
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int []arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        System.out.println();
        for(int i = 0;i < set.size();i++){
            if (i == set.size()-1) System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String d = sc.next();//double存不下
        char[] arr = d.toCharArray();
        int dot = d.indexOf('.');//寻找小数点下标
        String intStr = d.substring(0,dot);//整数部分
        double num1 = Math.pow(2,n) * Integer.valueOf(intStr);//计算整数部分
        double num2 = 0;
        double x = Math.pow(2,n);
        double tmp = 10;
        for(int i = dot + 1;i < d.length();i++){
            num2 += x * (1.0 * (arr[i] - '0') / tmp);
            tmp *= 10.0;
        }
        double sum = num1 + num2;
        System.out.println(Math.round(sum));
    }
}