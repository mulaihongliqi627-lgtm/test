import java.util.List;

public class MySingleList {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode head;
    //头插法
    public void creatList(){
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(19);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(28);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.head = node1;
    }
    public void showList(){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next=head;
        head = node;
    }
    //尾插法
    public void addLast(int data){}
    //任意位置插⼊,第⼀个数据节点为0号下标
    public void addIndex(int index,int data){}
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val==key) {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第⼀次出现关键字为key的节点
    public void remove(int key){}
    //删除所有值为key的节点
    public void removeAllKey(int key){}
    //得到单链表的⻓度
    public int size(){
        int count=0;
        ListNode cur = head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){}
    public void clear(){}


}
