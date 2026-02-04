import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        return A;
    }
    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root == null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */

    int size2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size2(root.left)+size2(root.right)+1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null&&root.right == null){
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null&&root.right == null){
            return 1;
        }
        return getLeafNodeCount2(root.left)+getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);

    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }


    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode tmp = find(root.left,val);
        if(tmp!=null){
            return tmp;
        }
        tmp = find(root.right,val);
        if(tmp!=null) {
            return tmp;
        }
        return null;
    }

    //层序遍历
    List<List<Character>> ret = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    class Solution {
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        public List<List<Character>> levelOrder(TreeNode root) {
            if (root == null) {
                return ret;
            }
            queue.offer(root);
            // 修正循环条件，队列非空才执行
            while (!queue.isEmpty()) {
                List<Character> list = new LinkedList<>();
                int size = queue.size();
                while (size != 0) {
                    TreeNode cur = queue.poll();
                    list.add(cur.val);
                    // 改用当前节点 cur 处理子节点
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    size--;
                }
                ret.add(list);
            }
            return ret;
        }
        // 二叉树的最近公共祖先
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return root;
            }
            if(root == p || root == q){
                return root;
            }
            TreeNode leftValue = lowestCommonAncestor(root.left,p,q);
            TreeNode rightValue = lowestCommonAncestor(root.right,p,q);
            if(leftValue != null && rightValue != null){
                return root;
            }else if(leftValue != null){
                return leftValue;
            }else {
                return rightValue;
            }
        }
    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        return true;
    }
}
