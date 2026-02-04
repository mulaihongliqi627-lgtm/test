public class Test {
    public static void main(String[] args) {
        int []array = new int[]{27,15,19,18,28,34,65,49,25,37};
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.createHeap(array);
        System.out.println(priorityQueue.peekHeap());
        priorityQueue.push(80);
        System.out.println(priorityQueue.peekHeap());
    }
}