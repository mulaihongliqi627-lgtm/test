import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}
//定义一个节点类
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
//    public int widthOfBinaryTree(TreeNode root) {
//        List<Pair<TreeNode,Integer>> list = new ArrayList<>();//数组模拟队列
//        list.add(new Pair<TreeNode,Integer>(root,1));
//        int ret = 0;
//        while(!list.isEmpty()){
//            Pair<TreeNode,Integer> t1 = list.get(0);//获取当前层的首节点
//            Pair<TreeNode,Integer> t2 = list.get(list.size() - 1);//获取当前层的尾节点
//            ret = Math.max(t2.getValue() - t1.getValue() + 1,ret);//计算当最大的层长度
//            List<Pair<TreeNode,Integer>> tmp = new ArrayList<>();
//            for(Pair<TreeNode,Integer> t : list){
//                TreeNode node = t.getKey();
//                int index = t.getValue();
//                if(node.left != null){
//                    tmp.add(new Pair<TreeNode,Integer>(node.left,index * 2));//左孩子加入队列
//                }
//                if(node.right != null){
//                    tmp.add(new Pair<TreeNode,Integer>(node.right,index * 2 + 1));//右孩子入队列
//                }
//            }
//            //此时已经处理完下一层
//            list = tmp;//覆盖
//        }
//        return ret;
//    }
}