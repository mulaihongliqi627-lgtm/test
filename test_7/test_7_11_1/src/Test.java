import java.util.Arrays;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入一个字符串: ");
        String str1=scanner.nextLine();
        Solution(String str1);


    }
    public static void main9(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=str1.toLowerCase();
        System.out.println(str2);

    }
    public static void main8(String[] args) {
        char []arr=new char[]{'a','b','c'};
        String str1=new String(arr);
        str1.intern();//入池
        String str2="abc";
        System.out.println(str1==str2);
    }
    public static void main7(String[] args) {
        String str="     have a good night cheems     ";
//        String []arr=str.split(" ",3);
//        for(String s:arr){
//            System.out.println(s);
//        }
        System.out.println("["+str+"]");
        System.out.println("["+str.trim()+"]");//String.trim()方法可以删除字符串左右两边的空格
//        String str="haveagoodnightcheems";
//        String []arr=str.split("n");
//        for(String s:arr){
//            System.out.println(s);
//        }
    }
    public static void main6(String[] args) {
        String s1="cheems";
        char[]arr=s1.toCharArray();
        //System.out.println(Arrays.toString(arr));
        /*for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }*/
        String s2=new String(s1);
        System.out.println(s2);
    }
    public static void main5(String[] args) {
        //大小写字母转化
        String s1="CHEEMS";
        String s2="cheems";
        System.out.println("转化后");
        System.out.println("==================");
        System.out.println(s1.toLowerCase());
        System.out.println(s2.toUpperCase());
    }
    public static void main4(String[] args) {
        String s1 = String.valueOf(1234);
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        //String s4 = String.valueOf(new Student("Hanmeimei", 18));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //System.out.println(s4);

    }
    public static void main3(String[] args) {
        char[]arr=new char[]{'a','b','c'};
        String str1=new String(arr);
        String str2=new String(arr);
        String str3=new String(arr);
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str2==str3);
        //引用类型比较的是地址，地址不同结果均为false
    }
    public static void main2(String[] args) {
        String str1="abc";
        String str2="abc";
        String str3=new String(str1);
        System.out.println(str1==str2);
        System.out.println(str1==str3);
    }
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.toString();

        for(int i=0;i<str1.length();i++){
            for(int j=i+1;j<str1.length();j++){

            }
        }
    }


}
