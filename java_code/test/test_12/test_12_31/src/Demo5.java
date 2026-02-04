import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class Demo5 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()){//root非空时，入队列
            int count = queue.size();
            List<Integer> path = new LinkedList<>();
            while (count-- > 0){
                Node head = queue.poll();//队首元素拿出，加入当层的链表中统计
                path.add(head.val);
                for(Node child : head.children){//把队首元素的孩子节点依次添加
                    if(child != null){
                        queue.add(child);
                    }
                }
            }
            list.add(path);
        }
        return list;
    }
}
