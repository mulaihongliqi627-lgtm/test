import java.util.Scanner;

public class Test {
    public static void Isdays(int year,int month,int days){
        int []monthDays={31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4==0&&year%100!=0||year%400==0){
            monthDays[1]+=1;
        }
        int totalDays=0;
        for(int i=0;i<month-1;i++){
            totalDays+=monthDays[i];
        }
        totalDays+=days;
        System.out.println(year+"年"+month+"月"+days+"日"+"是这一年的第"+totalDays+"天");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入年份");
        int year=scanner.nextInt();
        System.out.print("请输入月份");
        int month=scanner.nextInt();
        System.out.print("请输入日期");
        int days=scanner.nextInt();
        Isdays(year,month,days);
    }



    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入一个字母");
        char x = scanner.next().charAt(0);
        if(x>='a'&&x<='z'){
            x=(char)(x-'a'+'A');
            System.out.println(x);
        }
    }
}
