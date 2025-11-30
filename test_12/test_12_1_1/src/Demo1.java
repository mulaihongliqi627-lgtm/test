import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr);
        for(int i = n-1;i >=0;i--){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main1(String[] args) {
        int []arr = {3,4,2,5,7,6,1,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int []arr){
        sort(arr,0,arr.length-1);
        return;
    }
    public static void sort(int[]arr,int left,int right){
        if(left >= right){
            return;
        }
        int div = partition(arr,left,right);
        sort(arr,left,div-1);
        sort(arr,div + 1,right);
    }
    public static int partition(int []arr,int l,int r){
        int left = l,right = r;
        int base = arr[left];
        while (left < right){
            while (left < right && arr[right] >= base){
                right--;
            }
            while (left < right && arr[left]  <= base){
                left++;
            }
            if(left < right){
                swap(arr,left,right);
            }
        }
        swap(arr,l,left);
        return left;
    }
    public static void swap(int []arr ,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
