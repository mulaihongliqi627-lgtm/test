import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newHead = new ListNode();
        ListNode tailNode = newHead;
        int t = 0;
        while(cur1 != null || cur2 != null || t != 0){
            if(cur1 != null){
                t += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                t += cur2.val;
                cur2 = cur2.next;
            }
            tailNode.next = new ListNode(t%10);
            tailNode = tailNode.next;
            t /= 10;
        }
        return newHead.next;
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        ListNode cur = head;
        ListNode nextNode = cur.next;
        ListNode nnextNode = nextNode.next;

        while(cur != null && nextNode != null){
            //交换
            prev.next = nextNode;
            nextNode.next = cur;
            cur.next = nnextNode;
            //移动
            prev = prev.next.next;
            cur = cur.next.next;
            nextNode = nnextNode.next.next;
            nnextNode = nnextNode.next.next;
        }
        return newHead.next;
    }
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        System.out.println(list);
        list.add(1);
        System.out.println(list);
    }
}