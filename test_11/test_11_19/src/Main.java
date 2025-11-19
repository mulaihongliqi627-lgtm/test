import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
      public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
      ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }
    public ListNode mergeKLists(ListNode[] lists) {
        //定义小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        //1.把每一个链表的头结点创建小根堆
        for(ListNode head : lists){
            if(head != null){
                heap.offer(head);
            }
        }
        ListNode newHead = new ListNode();//创建虚拟头结点
        ListNode ret = newHead;//最终返回的链表头结点
        //2.合并链表
        while(!heap.isEmpty()){
            ListNode t = heap.poll();//获取最小头结点
            newHead.next = t;
            newHead = t;
            if(t.next != null){
                heap.offer(t.next);
            }
        }
        return ret.next;
    }
    public static void main(String[] args) {
    }
}