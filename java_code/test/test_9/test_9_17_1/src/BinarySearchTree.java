public class BinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public  TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode root;

    //查找
    public static boolean search(int key){
        if(root == null){
            return false;
        }
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == key){
                return true;
            } else if (cur.val > key) {
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        //走到这里说明遍历完整个树也没找到查找的key
        return false;
    }

    //插入
    public static void insert(int key){
        TreeNode newNode = new TreeNode(key);
        if(root == null){
            root = newNode;
            return;
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur!=null){
            if(cur.val > key){
                parent = cur;
                cur = cur.left;
            }else if(cur.val < key){
                parent = cur;
                cur = cur.right;
            }else{
                return;
            }
        }
        //此时parent指向插入cur的双亲节点
        if(parent.val > key){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
    }
    //删除
    public static void remove(int key){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur!=null){
            if(cur.val > key){
                parent = cur;
                cur = cur.left;
            }else if(cur.val < key){
                parent = cur;
                cur = cur.right;
            }else{
                removrKeyNode(cur,parent);
            }
        }
    }

    //删除节点
    private static void removrKeyNode(TreeNode cur,TreeNode parent){
        if(cur.right == null){
            if(cur == root){
                root = cur.left;//是单分支左树
                return;
            }else{
                if(cur == parent.left){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.right;
                }
            }
        }else if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else{
                if(cur == parent.left){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.right;
                }
            }
        }else{//此时cur左右都有节点，使用替换法删除cur，cur替换为其左子树最大值，右子树最小值
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left!=null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if(target == targetParent.left){
                targetParent.left = target.right;//target左子树最大值
            }else {
                targetParent.right = target.right;
            }

        }
    }

}
