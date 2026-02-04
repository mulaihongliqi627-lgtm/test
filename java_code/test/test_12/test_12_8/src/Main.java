import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long []arr1 = new long[n];
        long []arr2 = new long[n];
        for(int i = 0;i < n;i++) arr1[i] = sc.nextLong();
        for(int i = 0;i < n;i++) arr2[i] = sc.nextLong();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int change = 0,i = 0,j = 0;
        int count = 0;
        while (i < n && j < n){
            if(arr1[i] > arr2[j]){
                count++;
                i++;
                j++;
            }else{
                i++;
            }
        }
        System.out.println(n - count);
    }
}