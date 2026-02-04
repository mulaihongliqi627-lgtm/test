import java.util.Scanner;

class Main {
    public int fib(int n){
        int a1=1;
        int a2=1;
        int result=0;
        if(n<=2){
            return 1;
        }else{
            for(int i=3;i<n;i++){
                result=a1+a2;
                a1=a2;
                a2=result;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.toString();
        String str2=sc.toString();
        
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (sc.hasNextInt()) { // 注意 while 处理多个 case
            String line=sc.nextLine();
            for(char ch:line.toCharArray()){
                if(ch>'A'&&ch<'Z'){
                    System.out.println(ch);
                }else if(ch>'a'&&ch<'z'){
                    char x=(char)(ch+32);
                    System.out.println(x);
                    };
                }
            }


    }
}