//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public class TreeNode {
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
  private long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(left == false) return  false;
        boolean cur = false;
        if(root.val > prev) {
            cur = true;//当前节点值大于前驱，符合
        }else return false;//当前节点值小于前驱，剪枝
        prev = root.val;
        boolean right = isValidBST(root.right);
        return cur && left && right;
    }
}