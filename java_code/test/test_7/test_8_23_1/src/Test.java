//
//public class Test {
//    public static void main(String[] args) {
//        SingleLinkdeList list = new SingleLinkdeList();
//        list.addFirst(0);
//        list.addLast(5);
//        list.addLast(3);
//        list.addLast(7);
//        list.addLast(2);
//        list.addLast(7);
//        System.out.println(list.size());
//        list.display();
//        list.remove(7);
//        list.display();
////        list.addIndex(89,2);
////        list.display();
////        list.removeAllKey(7);
////        list.display();
////        list.display();
//    }
//}
public class Test {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addFirst(0); // 移除命名参数
        list.addLast(5);
        list.addLast(3);
        list.addLast(7);
        list.addLast(2);
        list.addLast(7);
        System.out.println(list.size()); // 修正为 list.size()
        list.display();
        list.remove(7); // 移除命名参数
        list.display();
        list.addIndex(89, 2); // 移除命名参数
        list.display();
        list.removeAllKey(7); // 移除命名参数
        list.display();

    }

}