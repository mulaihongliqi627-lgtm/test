import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int left = 0,right = 0,maxlen = 0;
        int start = 0;
        while(right < str.length()){
            //进窗口
            if(Character.isDigit(str.charAt(right))){
                right++;
                if(right - left >maxlen){
                    maxlen = right - left;
                    start = left;//记录最长数字子串的起始下标
                }
            }else {//出窗口
                right++;
                left = right;
            }
        }
        for(int i = 0;i < maxlen;i++){
            System.out.print(str.charAt(start++));
        }
    }

    public static void main2(String[] args) {
        char[][]grid = {{'1','1','0','0','0'},{'0','1','0','1','1'},
                {'0','0','0','1','1'}, {'0','0','0','0','0'},{'0','0','1','1','1'}};
        int result = solve(grid);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){
            int []arr = new int[6];
            for(int i = 0;i < 6;i++){
                arr[i] = scanner.nextInt();
            }
            if(isTwoTriangle(arr)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    //判断数组中六个数能否构成两个三角形
    public static boolean isTwoTriangle(int []arr){
        Arrays.sort(arr);
        if(triangle(arr[0],arr[1],arr[2]) && triangle(arr[3],arr[4],arr[5])){
            return true;
        }
        if(triangle(arr[0],arr[1],arr[3]) && triangle(arr[2],arr[4],arr[5])){
            return true;
        }
        if(triangle(arr[0],arr[1],arr[4]) && triangle(arr[2],arr[3],arr[5])){
            return true;
        }
        return false;
    }
    public static boolean triangle(int a,int b,int c){
        return a+b>c&&a+c>b&&b+c>a;
    }
    public static int solve (char[][] grid) {
        int sumLand = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid.length;j++){
                if(grid[i][j] == '1'){
                    sumLand++;
                    island(grid,i,j);
                }
            }
        }
        return sumLand;
    }
    public static void island(char[][]grid,int i,int j){
        //处理边界情况
        if(i < 0||i >= grid.length||j < 0||j >= grid[0].length){
            return ;
        }
        if(grid[i][j] == '0'){
            return ;
        }
        grid[i][j] = '0';//做标记
        //递归检查上下左右四个方向
        island(grid,i-1,j);
        island(grid,i+1,j);
        island(grid,i,j-1);
        island(grid,i,j+1);
    }
}