import java.util.*;

public class Demo2 {

    public static int[] findOrder(int n, int[][] p) {
        int []in = new int [n];//入度数组
        int []ret = new int [n];
        int k = 0;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        //统计入度数
        for(int i = 0;i < p.length;i++){
            int a = p[i][0],b = p[i][1];
            if(!edges.containsKey(b)){
                edges.put(b,new ArrayList<>());
            }
            edges.get(b).add(a);//添加和b相连的后续节点
            in[a]++;
        }
        //把入度为0的节点添加到队列中
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < in.length;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int tmp = q.poll();
            ret[k++] = tmp;//把结果添加到ret中.为选课的顺序
            for(int x : edges.getOrDefault(tmp,new ArrayList<>())){
                in[x]--;
                if(in[x] == 0){
                    q.add(x);
                }
            }
        }
        if(k != n) return new int[0];//说明有环
        return ret;
    }

    public static void main(String[] args) {
        int [][]x = {{1,0}};
        int []ret = findOrder(2,x);
        System.out.println(Arrays.toString(ret));
    }
}
