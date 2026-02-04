import java.util.Scanner;

public class Test {
    public static void bubbleSort(int[] array){//冒泡排序
        int i,j,tmp;
        for(i=0;i<array.length-1;i++){
            for (j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    tmp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
    public static boolean threeOddNumber(int[]arr){//判断一个数组中是否有连续三个奇数存在
        int i,j;
        for(i=0;i< arr.length;i++){
            for(j=i+1;j< arr.length-1;j++){
                if(arr[i]%2!=0&&arr[j]%2!=0&&arr[j+1]%2!=0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main1(String[] args) {
        int[]array={1,6,2,3,9,8,5};
        bubbleSort(array);
        int i;
        for(i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j;
        int[]num=new int[7];
        for(i=0;i<7;i++){
            num[i]= sc.nextInt();
        }
        int target= sc.nextInt();
        for(i=0;i<7;i++){
            for(j=i+1;j<7;j++){
                if(num[i]+num[j]==target){
                    System.out.println(i+" "+j);
                }
            }
        }
    }

    public static void main3(String[] args) {//单身狗数查找
        int[] arr=new int[5];
        Scanner sc=new Scanner(System.in);
        int i,j,flag=0;
        for(i=0;i<5;i++){
            arr[i]= sc.nextInt();
        }
        for (i=0;i<5;i++){
            for(j=i+1;j<5;j++){
                if(arr[i]==arr[j]){
                    flag=1;//arr[i]不是单身狗数
                    continue;
                }
            }
            if(flag==0) {
                System.out.println("单身狗数是" + arr[i]);
                break;
            }
        }
    }

    public static void main4(String[] args) {//多数元素查找
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入数组的大小：");
        int n= sc.nextInt();
        int i,j;
        int[]arr=new int[n];
        for(i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        for(i=0;i<n;i++){
            int count=1;
            for(j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/2){
                System.out.println("多数元素是"+arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[9];
        int i;
        for (i=0;i<9;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(threeOddNumber(arr));


    }
}
