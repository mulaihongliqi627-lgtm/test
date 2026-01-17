import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ret = new ArrayList<>();//结果数组
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(root == null){
            return ret;
        }
        while(!queue.isEmpty()){
            int max = queue.peek().val;
            for(TreeNode t : queue){//遍历当前层，寻找最大值
                if(t.val > max){
                    max = t.val;
                }
            }
            ret.add(max);//把每一层的最大值添加到ret数组
            Queue <TreeNode> tmp = new LinkedList<>();
            for(TreeNode t : queue){//处理下一层
                if(t.left != null){
                    tmp.add(t.left);
                }
                if(t.right != null){
                    tmp.add(t.right);
                }
            }
            queue = tmp;//更新queue为下一层的
        }
        return ret;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

    }
}