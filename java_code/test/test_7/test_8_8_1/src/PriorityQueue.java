import java.util.Arrays;

public class PriorityQueue {
    public int[] elem;
    public int usedSize;

    public PriorityQueue() {
        this.elem = new int [15];
    }

    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for(int i = 0;i<array.length;i++) {
            elem[i] = array[i];
            usedSize++;
        }
        for(int parent = (usedSize-1-1)/2;parent>=0;parent--){
            shiftDown(parent,usedSize);
        }
    }

    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    public void shiftDown(int root,int len) {
        int child = root*2+1;
        while(child < len){
            if((child+1) < len && elem[child] < elem[child+1]){//root有两个根节点的情况
                child++;//确保child指向的是root的孩子节点中的值大的节点
            }
            if(elem[child] > elem[root]){
                swap(child,root);
                root = child;
                child = root * 2 + 1;
            }else {
                break;
            }
        }
    }

    //交换元素的值
    public void swap(int i,int j){
        int tmp = elem[i];
        elem[i] = elem[j];
        elem[j] = tmp;
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()){
            //满则数组长度二倍扩容
            elem = Arrays.copyOf(elem,elem.length*2);
        }
        elem[usedSize] = val;
        usedSize++;
        shiftUp(usedSize-1);
    }

    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0){
            if(elem[child] > elem[parent]){
                swap(child,parent);
                child = parent;
                parent = (child - 1)/2;
            }else{
                //如果末位添加元素值比parent节点的小，则已经是大根堆，无需进行调整
                break;
            }
        }
    }

    //判满
    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        if(isEmpty()){
            return;
        }
        swap(elem[0],elem[usedSize-1]);
        usedSize--;//忽略最后一个元素，把其余元素维护成大根堆
        shiftDown(0,usedSize);
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        if(isEmpty()){
            return -1;
        }
        return elem[0];
    }
}
