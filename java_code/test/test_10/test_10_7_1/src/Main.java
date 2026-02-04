public class Main {
    public static void main(String[] args) {
        int []arr = new int[]{1,0,-1,0,-2,2};
        int target = 0;

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-3;i++){
            //去重
            while(i < nums.length-3 && nums[i] == nums[i+1]){
                i++;
                continue;
            }
            int a = nums[i];
            for(int j = i+1;j < nums.length-2;j++){
                int b = nums[j];
                //去重
                while(j < nums.length-2 && nums[j] == nums[j+1]){
                    j++;
                    continue;
                }
                int left = j+1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] > target-a-b){
                        right--;
                        continue;
                    }else if(nums[left] + nums[right] < target-a-b){
                        left++;
                        continue;
                    }else{
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    }
                    //去重
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}