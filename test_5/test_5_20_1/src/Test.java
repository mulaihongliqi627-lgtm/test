import java.util.Scanner;

public class Test {
    public static void transform(int []array,int i){//数组数字改变
        for(i=0;i<array.length;i++){
            array[i]=array[i]*2;
            System.out.print(array[i]+" ");
        }
    }
    public static void swp1(int []array,int i,int j){//交换奇数偶数
        int tmp=0;
        while(i<j){
            if(array[i]%2==0&&array[j]%2!=0) {
                tmp=array[i];
                array[i]=array[j];
                array[j]=tmp;
            }
            i++;
            j--;
        }
    }
    public static void search(int[]array,int goal){//二分查找
        int left=0,right=array.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(array[mid]>goal){
                right=mid;
            }
            if(array[mid]<goal){
                left=mid;
            }
            if(array[mid]==goal){
                System.out.println("下标是"+mid);
                break;
            }
            if(array[right]==goal){
                System.out.println("下标是"+right);
                break;
            }
        }
        if(left>right) {
            System.out.println("找不到");
        }
    }
    public static void main1(String[] args) {
        int []array={1,2,3};
        int i=0;
        transform(array,i);
    }

    public static void main2(String[] args) {
        int []array={1,2,3,4,5,6};
        int i=0,j=array.length-1;
        swp1(array,i,j);
        for (i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8};
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入要查找的元素: ");
        int goal=sc.nextInt();
        search(array,goal);
    }

}
