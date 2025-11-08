//public class SingleLinkdeList {
//    public class ListNode{
//        public int val;
//        public ListNode next;
//
//        public ListNode(int val){
//            this.val = val;
//            this.next = null;
//        }
//    }
//    public ListNode head;
//    //头插法
//    public void addFirst(int data){
//        ListNode node = new ListNode(data);
//        node.next = head;
//        head = node;
//    }
//    //尾插法
//    public void addLast(int data){
//        ListNode node = new ListNode(data);
//        ListNode cur = head;
//        if(head == null){
//            head = node;
//            return;
//        }
//        while (cur.next != null){
//            cur = cur.next;
//        }
//        cur.next = node;
//        node.next = null;
//    }
//    //指定位置插入节点,初始节点下标为0
//    public void addIndex(int data,int index) {
//        if(index < 0|| index > size()){
//            throw new IndexOutOfBoundsException("下标范围异常");
//        }
//        if(index == 0){
//            addFirst(data);
//            return;
//        }
//        if(index == size()-1){
//            addLast(data);
//            return;
//        }
//        ListNode node = new ListNode(data);
//        ListNode cur = head;
//        for (int i = 0; i < index-1; i++) {
//            cur = cur.next;
//        }
//        node.next = cur.next;
//        cur.next = node;
//    }
//    //查找是否包含关键字key是否在单链表当中
//    public boolean contains(int key){
//        ListNode cur = head;
//        while (cur.next!=null){
//            if(cur.val == key){
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
//    }
//
//    //删除第⼀次出现关键字为key的节点
//    public void remove(int key){
//        if(head == null){
//            return;
//        }
//        if(head.val == key){
//            head = head.next;
//            return;
//        }
//        ListNode pre = findPreNode(key);
//        pre.next = pre.next.next;
//    }
//    //找到前驱节点
//    public ListNode findPreNode(int key){
//        ListNode cur = head;
//        if(cur.val == key){
//            return null;//没有前驱节点
//        }
//        while (cur.next.val!=key){
//            cur = cur.next;
//        }
//        ListNode pre = cur;
//        return pre;
//    }
//    //删除所有值为key的节点
//    public void removeAllKey(int key){
//        if(head.val==key){
//            head = head.next;
//        }
//        ListNode cur = head;
//        while (cur != null){
//            if(cur.next.val == key){
//                cur = cur.next.next;
//            }else {
//                cur = cur.next;
//            }
//        }
//    }
//    //得到单链表的⻓度
//    public int size(){
//        ListNode cur = head;
//        int len = 0;
//        while (cur != null){
//            len++;
//            cur = cur.next;
//        }
//        return len;
//    }
//    //打印链表中各个节点的值
//    public void display(){
//        ListNode cur = head;
//        while (cur!=null){
//            System.out.print(cur.val+" ");
//            cur = cur.next;
//        }
//        System.out.println();
//    }
//
//    public void clear(){
//        head = null;
//
public class SingleLinkedList {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode head;

    // 头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    // 尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            head = node;
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    // 指定位置插入节点,初始节点下标为0
    public void addIndex(int data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    // 查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 找到前驱节点
    private ListNode findPreNode(int key) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // 删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
            return;
        }

        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode pre = findPreNode(key);
        if (pre != null) {
            pre.next = pre.next.next;
        }
    }

    // 删除所有值为key的节点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }

        // 处理头节点为key的情况
        while (head != null && head.val == key) {
            head = head.next;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == key) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    // 得到单链表的长度
    public int size() {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    // 打印链表中各个节点的值
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        head = null;
    }
}
