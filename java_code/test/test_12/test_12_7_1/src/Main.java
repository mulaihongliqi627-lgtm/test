import javax.sql.rowset.serial.SerialStruct;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main1(String[] args) {
        String s1 = "114";
        String s2 = "114";
        String s3= new String("114");
        System.out.println(s1 == s2);//结果为true
        System.out.println(s1 == s3 || s2 == s3);//结果为false
        System.out.println(s1.equals(s3) && s2.equals(s3));//比较内容,结果为true
    }
    public class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if(root == null) return list;
        dfs(root,"");
        return list;
    }
    public void dfs(TreeNode root, String path){
        if(root.left == null && root.right == null){//遇到叶子节点
            path += String.valueOf(root.val);
            list.add(path);
            return;//回溯
        }
        path += String.valueOf(root.val + "->");
        dfs(root.left,path);
        dfs(root.right,path);
    }

    private List<List<Integer>> List;
    private List<Integer> path;
    private boolean[]check;//默认为false，代表未使用
    public List<List<Integer>> permute(int[] nums) {
        List = new ArrayList<>();
        path = new ArrayList<>();
        int n = nums.length;
        check = new boolean[n];//用于判断某个未知的数是否被使用过
        dfs(nums);
        return List;
    }
    public void dfs(int []nums){
        if(path.size() == nums.length){//一种全排列可能
            List.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(check[i] == false){//未使用
                path.add(nums[i]);
                check[i] = true;
                dfs(nums);
                //在return之后回溯恢复
                check[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//    public int choice(int []arr,int a,int b){
//        long num0 = a;
//        long num1 = b;
//        int count = 0;
//       // if(arr.length <= 1 && )
//        for(int i = 2;i < arr.length;i++){
//            long x = num1 + num0;
//            if(x != arr[i]){
//                count++;
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        if(arr[0] != arr[1]){
            count ++;
            arr[1] = arr[0];
        }
        for(int i = 2;i < n;i++){
            if(arr[i] != arr[i-1] + arr[i-2]){
                count++;
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        System.out.println(count);
    }
}