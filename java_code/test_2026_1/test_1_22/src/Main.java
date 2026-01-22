import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    char[]gene = {'A','C','G','T'};
    Set<String> vis = new HashSet<>();//转化的基因
    Set<String> hash2 = new HashSet<>();//基因库hash
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene == endGene) return 0;
        for(String str : bank){//把基因库基因添加到hash2表中
            hash2.add(str);
        }
        if(!hash2.contains(endGene)) return -1;//基因库中不存在最终目的基因，无法变化
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        vis.add(startGene);
        int step = 0;//基因变化的步数
        while (!q.isEmpty()){
            step++;
            int sz = q.size();//当前层的个数
            while (sz-- > 0){
                String tmp = q.poll();//遍历当前层的所有字符串
                for(int i = 0;i < 8;i++){
                    for(int j = 0;j < 4;j++){//一个字符位四次变化
                        char[]t = tmp.toCharArray();
                        t[i] = gene[j];//基因转化
                        String next = new String(t);//恢复为字符串
                        if(next.equals(endGene)){//转化后的基因已经是最终变化的目的基因，直接return
                            return step;
                        }
                        if(!vis.contains(next) && hash2.contains(next)){//vis中不存在,该类型基因为初次出现
                            vis.add(next);//添加，避免之后的基因变化为之前已经变过的
                            q.add(next);//就添加到队列中
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}