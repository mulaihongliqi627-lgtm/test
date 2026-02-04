import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []arr =new int[]{4,2,3,4};
        int count = triangleNumber(arr);
        System.out.println(count);
    }
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length - 1;
        int count = 0;
        while(k >= 2){
            int i = 0;
            int c = nums[k];
            int j = k - 1;
            while(i < j){
                int a = nums[i];
                int b = nums[j];
                if(a + b > c){
                    count +=(j - i);
                    j--;
                }else{
                    i++;
                }
            }
            k--;
        }
        return count;
    }
}