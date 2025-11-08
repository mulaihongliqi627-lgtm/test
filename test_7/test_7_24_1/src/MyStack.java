import java.util.Arrays;

public class MyStack {
    int []Array;
    int size;//栈中元素的个数

    public MyStack() {
        Array = new int[3];
    }
    //入栈
    public int push(int e){
        //确保栈空间有剩余
        ensureCapacity();
        Array[size] = e;
        size++;
        return e;
    }
    //弹出栈顶元素并且返回
    public int pop(){
        int e = Array[size-1];
        size--;
        return e;

    }
    //获取栈顶元素
    public int peek(){
        if(empty()) {
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }
        return Array[size-1];
    }
    //判断栈中有无元素
    public boolean empty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;

    }
    public void ensureCapacity(){
        if(Array.length==size){
            Array = Arrays.copyOf(Array,size*2);
        }
    }
}
