public class Pracitce {
    //移动0
    public void moveZeroes(int[] nums) {
        for(int i = 0,j = -1;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }else{
                swap(i,++j,nums);
            }
        }
    }
    public void swap(int i,int j,int []arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
