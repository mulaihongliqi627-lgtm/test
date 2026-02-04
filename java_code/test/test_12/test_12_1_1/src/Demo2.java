import java.util.Scanner;

public class Demo2 {
    public static void main1(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []arr1 = new int[n];
        int []arr2 = new int[m];
        int []nums = new int[m + n];
        for(int i = 0;i < n;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0;i < m;i++){
            arr2[i] = sc.nextInt();
        }
        int i = 0,j = 0,k = 0;
        while (i < n && j < m){
            if(arr1[i] < arr2[j]){
                nums[k++] = arr1[i++];
            }else{
                nums[k++] = arr2[j++];
            }
        }
        while (i < n){//处理未遍历完的数组
            nums[k++] = arr1[i++];
        }
        while (j < m){
            nums[k++] = arr2[j++];
        }
        for(int x : nums){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int []arr1 = new int[n];
        for(int i = 0;i < n;i++){
            arr1[i] = sc.nextInt();
        }
        int i = 0,j = n - 1;
        while (i < j){
            while (arr1[i] % 2 != 0){//左边找到第一个偶数
                i++;
            }
            while (arr1[j] % 2 ==0){//右边找到以一个奇数
                j--;
            }
            if(i < j){
                swap(arr1,i++,j--);
            }
        }
        for(int x : arr1){
            System.out.print(x + " ");
        }
    }
    public static void swap(int []arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
