public class Test {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.addTail(6);
        list.deleteKeyData(3);
        list.add(12,3);
        list.addHead(11);
        list.display();
        System.out.println("数组中一共有"+list.getUsedsize()+"个有效元素");
    }
}
