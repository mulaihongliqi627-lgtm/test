import java.util.Comparator;
import java.util.PriorityQueue;

//基于创建大小堆实现数据流中位数查找
public class MedianFinder {
    PriorityQueue<Integer>heap1;
    PriorityQueue<Integer>heap2;
    private int m,n;//左右两个堆中元素的个数
    public MedianFinder() {
        heap1 = new PriorityQueue<>(Comparator.reverseOrder());//大堆
        heap2 = new PriorityQueue<>();//小堆
    }

    public void addNum(int num) {
        m = heap1.size();
        n = heap2.size();
        if(m == n){
            if(heap1.isEmpty() || num <= heap1.peek()){
                heap1.offer(num);//入大堆
            }else if(num > heap1.peek()){
                heap2.offer(num);//此时小堆中元素多于大堆，需要把堆化后的小堆顶元素移到大堆中
                heap1.offer(heap2.poll());//确保大堆元素 = 小堆元素 + 1
            }
        }
        if(m > n){
            if(num <= heap1.peek()){
                heap1.offer(num);
                heap2.offer(heap1.poll());//m = n + 2、大堆取堆顶元素给小堆
            }else{
                heap2.offer(num);
            }
        }
    }

    public double findMedian() {
        double ret = 0;
        //判断整体数据个数的奇偶性
        if((heap1.size() + heap2.size()) % 2 == 0){
            ret = 1.0 * (heap1.peek() + heap2.peek()) / 2;
        }else{
            ret = heap1.peek();
        }
        return ret;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
