package demo;

import java.util.Scanner;

public class Main1 {
    static int t[];//到达机场时间
    static int d[];//可盘旋时间
    static int l[];//降落所需时间
    static int N;
    static boolean st[];//标记每一个飞机的状态
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int j = 0;j < T;j++){
            N = sc.nextInt();//飞机个数
            t = new int[N];
            d = new int[N];
            l = new int[N];
            st = new boolean[N];
            for(int i = 0;i < N;i++){
                t[i] = sc.nextInt();
                d[i] = sc.nextInt();
                l[i] = sc.nextInt();
            }
            if(dfs(0,0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    //n是已经降落的飞机个数,time是前一个飞机降落完毕的时间
    public static boolean dfs(int n,int time){
        if(n >= N) return true;//全部飞机都可以降落
        for(int i = 0;i < N;i++){
            if(!st[i]) {
                if (t[i] + d[i] < time) {//等到燃油耗尽也没等到上一架飞机降落完毕
                    continue;//换一架飞机开始尝试
                }
                st[i] = true;//选中i飞机开始尝试降落

                int startTime = Math.max(time, t[i]);//开始降落的时刻
                int landedTime = startTime + l[i];//降落完毕时刻
                if (dfs(n + 1, landedTime)) {//递归查看下一架飞机是否可以成功降落
                    return true;
                }
                st[i] = false;//回溯
            }
        }
        return false;
    }
}
