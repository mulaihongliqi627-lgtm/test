import java.util.*;

public class Demo1 {
    public boolean canFinish(int n, int[][] p) {
        int []in = new int [n];//入读数组，in[i]表示i的入度值
        Map<Integer, List<Integer>> edges = new HashMap<>();
        //建图
        for(int i = 0;i < p.length;i++){
            int a = p[i][0];//后继
            int b = p[i][1];//前介
            if(!edges.containsKey(b)){//不存在b对应的相连链表
                edges.put(b,new ArrayList<>());
            }
            edges.get(b).add(a);
            in[a]++;//a的入度加1，b是前驱无需增加
        }
        //把入度为0的点加入队列
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < in.length;i++){
            if(in[i] == 0){
                q.add(i);//i对应的是点，in[i]则是该点的入度值
            }
        }
        //遍历图
        while (!q.isEmpty()){
            int tmp = q.poll();//得到入度为0的点
            //删除与其相连的边,即让与其相连的点的入度减1,也即Map中与其映射的List中的点入度减1
            for(int x : edges.getOrDefault(tmp,new ArrayList<>())){
                in[x]--;//去除与其相连的边对应点的入度减1
                if(in[x] == 0){//如果去除边后入度为0，则可以添加到队列中
                    q.add(x);
                }
            }
        }
        for(int x : in){
            if(x != 0){//存在环
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
