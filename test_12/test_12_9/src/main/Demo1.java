package main;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0){
            int n = sc.nextInt();//数字个数
            int rot = sc.nextInt();//转动次数
            int []arr = new int[n];
            for(int i = 1;i <= n;i++) arr[i-1] = i;
            StringBuilder initStr = new StringBuilder(Arrays.toString(arr));//保存初始状态
            if(rot >= n) rot %= n;
            //数组移动k位
            reverse(arr,0,n-1);
            reverse(arr,0,rot-1);
            reverse(arr,rot,n-1);
            String str1 = Arrays.toString(arr);//保存旋转后的状态
            StringBuilder str2 = new StringBuilder();
            int change = 0;
            while (!str2.toString().equals(initStr.toString())){
                reverse(arr,0,n-2);
                reverse(arr,1,n-1);
                str2 = new StringBuilder(Arrays.toString(arr));//记录一次操作后的状态
                change++;
                if(str2.toString().equals(str1.toString())){//出现死循环
                    change = -1;
                    System.out.println(change);
                    return;
                }
            }
            if(change != -1){
                System.out.println(change);
            }
            T--;
        }

    }
    //反转数组
    public static void reverse(int []arr,int i,int j){
        while (i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
