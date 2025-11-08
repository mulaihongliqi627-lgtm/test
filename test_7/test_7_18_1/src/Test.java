public class Test {
    public static int missingNum(int[]arr){
        int sum=0;
        int n= arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int result=n*(1+n)/2;
        return result-sum;
    }

    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,0,4,7,9,5,8};
        System.out.println(missingNum(arr));
    }
}
