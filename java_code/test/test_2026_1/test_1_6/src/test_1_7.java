import java.util.LinkedList;
import java.util.List;

public class test_1_7 {

}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        int level = 1;//遍历的二叉树层数
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//预处理根节点
        while(!queue.isEmpty()){
            int size = queue.size();//计算当前层的节点数
            List<Integer> list = new LinkedList<>();//计算当前层的节点数据
            while(size-- > 0){
                TreeNode t = queue.poll();//获取到当前层的最左边的节点
                list.add(t.val);
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            if(level % 2 == 0) Collections.reverse(list);//偶数层，逆序list，实现二叉树Z字遍历
            ret.add(list);
            level++;
        }
        return ret;
    }

}
