import javax.swing.tree.TreeNode;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree .createTree();
        BinaryTree.TreeNode root = binaryTree .createTree();
        //前序遍历
        binaryTree.preOrder(root);
        System.out.println();
        //中序遍历
        binaryTree.inOrder(root);
        System.out.println();
        //后序遍历
        binaryTree.postOrder(root);
        System.out.println();
        //节点个数
        System.out.println("总节点数: "+binaryTree.size2(root));
        System.out.println("第k层节点个数: "+binaryTree.getKLevelNodeCount(root,3));
        System.out.println("二叉树高度: "+binaryTree.getHeight(root));
        binaryTree.find(root,'E');

    }
    public void shiftup(int child){
        int parent = (child-1)/2;
        while(child > 0){
            if(elem[child] > elem[parent]){

            }
        }
    }
}
