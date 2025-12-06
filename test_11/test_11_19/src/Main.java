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
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ret = mergerSort(lists,0,lists.length - 1);
        return ret;
    }
    public ListNode mergerSort(ListNode [] lists,int left,int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return lists[left];//单链表，无须合并直接返回头结点
        }
        int mid = (left + right) / 2;
        //[left ,mid],[mid + 1,right]
        ListNode l1 = mergerSort(lists,left,mid);
        ListNode l2 = mergerSort(lists,mid + 1,right);
        return mergerTwoList(l1,l2);
    }

    //合并两个有序链表
    public ListNode mergerTwoList(ListNode l1,ListNode l2){
        ListNode newHead = new ListNode();//虚拟头结点,表示合并链表的最后一个节点
        ListNode ret = newHead;//最终链表头结点前一个节点
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode cur1 = l1,cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                newHead.next = cur1;
                newHead = cur1;//虚拟头结点后移
                cur1 = cur1.next;
            }else{
                newHead.next = cur2;
                newHead = cur2;
                cur2 = cur2.next;
            }
        }
        //结束循环后，合并链表长度不一致，结束循环后还有链表为全部合并到长链表上，需要链接剩余部分
        if(cur1 != null){
            newHead.next = cur1;
        }
        if(cur2 != null){
            newHead.next = cur2;
        }
        return ret.next;
    }

}