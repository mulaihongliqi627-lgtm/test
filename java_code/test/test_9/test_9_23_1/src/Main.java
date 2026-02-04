import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int x = q;
        int [][]arr = new int [q][3];
        for(int i =0 ;i < q;i++){
            for(int j = 0;j < 3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i < x;i++){
            int j = 0;
            int Score = maxScore(i,arr);
            System.out.println(Score);
        }


    }
    public static int maxScore(int i,int[][]arr){
        int a = arr[i][0];
        int b = arr[i][1];
        int c = arr[i][2];
        int totalScore = 0;
        //先判断能凑出几个you
        while(a != 0 && b != 0 && c!=0){
            totalScore+=2;
            a--;
            b--;
            c--;
        }
        //再判断可以凑出几个相邻的oo
        if(b >= 2){
            totalScore += (b-1);
        }
        return totalScore;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = sc.nextLine();//输入一个字符串
        str = str.toUpperCase();//把字符串全部转化为大写字母
        char []arr = new char[20];
        arr[0] = str.charAt(0);
        int j = 0;
        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if(ch == ' '){
                arr[j++] = ch;
            }
        }
        int k = 0;
        while(arr[k]!='0'){
            System.out.print(arr[k++]+' ');
        }
    }
}