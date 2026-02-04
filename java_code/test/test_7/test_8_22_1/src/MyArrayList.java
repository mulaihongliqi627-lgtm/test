import java.util.Arrays;

public class MyArrayList {
    public int[] array;
    public int usedsize;

    public int initArrayLen = 10;
    public MyArrayList(){
        array = new int [initArrayLen];
    }
    public MyArrayList(int len){
        array = new int [len];
    }
    //尾插
    public void addTail(int data){
        if(isFull()){
            grow();
        }
        array[usedsize] = data;
        usedsize++;
    }
    //头插
    public void addHead(int data){
        if(isFull()){
            grow();
        }
        for(int i = usedsize-1;i>=0;i--){
            array[i+1] = array[i];
        }
        array[0] = data;
        usedsize++;
    }
    //指定下标插入数据
    public void add(int data,int index){
        if(isFull()){
            grow();
        }
        if(index > usedsize || index < 0){
            throw new ArrayIndexOutOfBoundsException("插入数据的下标不合法");
        }
        for(int i = usedsize-1;i>=index;i--){
            array[i+1] = array[i];
        }
        array[index] = data;
        usedsize++;
    }

    //删除指定元素
    public void deleteKeyData(int data){
        int index = findIndex(data);
        if(index == -1){
            System.out.println("没有你要删除的元素");
        }
        for(int i = index;i < usedsize-1;i++){
            array[i] = array[i+1];
        }
        usedsize--;
    }
    //找到指定数据的索引并返回
    public int findIndex(int data){
        for(int i = 0;i < usedsize;i++){
            if(data == array[i]){
                return i;
            }
        }
        return -1;//找不到指定元素
    }

    //查找数组中是否包含要找的元素
    public void contain(int data){
        for(int i = 0;i < usedsize;i++){
            if(array[i]==data){
                System.out.println("数组中含有该元素");
            }
        }
        System.out.println("找不到");
    }
    //修改指定下标元素的值
    public void set(int index,int data){
        if(index >= usedsize||index < 0){
            throw new ArrayIndexOutOfBoundsException("下标范围不合法");
        }
        array[index] = data;
    }
    public int getUsedsize(){
        return usedsize;
    }
    //判空
    public boolean isEmpty(){
        return usedsize == 0 ;
    }
    //判满
    public boolean isFull(){
        return usedsize == array.length;
    }
    //数组扩容，二倍扩容
    public void grow(){
        array = Arrays.copyOf(array,array.length*2);
    }
    //数组打印
    public void display(){
        System.out.println(Arrays.toString(array));
    }
}
