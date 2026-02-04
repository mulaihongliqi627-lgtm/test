import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer>qu1 = new LinkedList<>();
    Queue<Integer>qu2 = new LinkedList<>();
    public void push(int x) {
        if(qu1.isEmpty()&&qu2.isEmpty()){
            qu1.offer(x);
        }else if(!qu1.isEmpty()){
            qu1.offer(x);
        }else{
            qu2.offer(x);
        }
    }
    public int pop() {
        if(!qu1.isEmpty()){
            while(qu1.size()>1){
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }else{
            while(qu2.size()>1){
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }

    public int top() {
        if(!qu1.isEmpty()){
            while(qu1.size()>1){
                qu2.offer(qu1.poll());
            }
            return qu1.peek();
        }else{
            while(qu2.size()>1){
                qu1.offer(qu2.poll());
            }
            return qu2.peek();
        }
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}
