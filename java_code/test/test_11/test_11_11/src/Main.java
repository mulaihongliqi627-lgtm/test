public class Main {
    public int[] inventoryManagement(int[] nums, int k) {
        quickSort(nums,0,nums.length-1,k);
        int []arr = new int[k];
        for(int i =0;i < k;i++){
            arr[i] = nums[i];
        }
        return arr;
    }
    public static void quickSort(int []nums,int l,int r,int k){
        if(l >= r){
            return;
        }
        int left = l-1,right = r+1,i = l;
        int base = nums[new Random().nextInt(r - l + 1) + l];
        while(i < right){
            if(nums[i] < base){
                swap(nums,++left,i++);
            }else if(nums[i] == base){
                i++;
            }else{
                swap(nums,i,--right);
            }
        }
        int a = left - l + 1,b = right - left - 1,c = r - right + 1;
        if(k < a){
            quickSort(nums,l,left,k);
        }else if(k <= a + b){
            return;
        } else{
            quickSort(nums,right,r,k);
        }
    }
    public static void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}