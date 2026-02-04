import java.util.PriorityQueue;

public class Demo2 {

}

class KthLargest {
    private int k;
    private PriorityQueue<Integer> heap;
    public KthLargest(int _k, int[] nums) {
        this.k = _k;
        heap = new PriorityQueue<>();
        for(int x : nums){
            heap.offer(x);
            if(heap.size() > k){//此时堆顶元素一定不是第k大元素
                heap.poll();//出堆
            }
        }
    }
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}
