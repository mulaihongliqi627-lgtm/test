import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo1 {
    public static int lastStoneWeight(int[] stones) {
        //逆序优先级队列,优先级：从大到小
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i < stones.length;i++){
            queue.add(stones[i]);
        }
        int x = 0,y = 0;
        while (queue.size() >= 2){
            y = queue.poll();//最重的两个石头
            x = queue.poll();
            if(x < y){
                queue.add(y-x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
    public static void swap(int i,int j,int []arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int []stones = {2,7,4,1,8,1};
        int ret = lastStoneWeight(stones);
        System.out.println(ret);
    }
}
