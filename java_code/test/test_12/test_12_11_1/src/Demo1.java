import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int totalBlocks = C+1;//需要构建的字符块个数
        int startType;//开始的类型
        int block_L = 0,block_Q = 0;
        StringBuilder s = new StringBuilder();
        if(check(0,A,B,totalBlocks)){//L开头可以实现
            startType = 0;
            block_L = (totalBlocks + 1)/2;
            block_Q = totalBlocks/2;
        }else if(check(1,A,B,totalBlocks)){
            startType = 1;
            block_L = totalBlocks/2;
            block_Q = (totalBlocks + 1)/2;
        }else{
            System.out.println(-1);
            return;
        }
        for(int i = 0;i < totalBlocks;i++){
            if(startType == 0){//从L开始填字母块
                block_L--;
                int L_curBlockLen = A - block_L;
                for(int j = 0;j < L_curBlockLen;j++) s.append('L');//只要不剩一个，能放多长就多长
                A = A - L_curBlockLen;//更新剩余的L字符个数
                startType = 1;//换Q来
            }else{
                block_Q--;
                int Q_curBlockLen;//Q尽可能少放，只要不是剩一个就每次放一个
                if(block_Q == 0){
                    Q_curBlockLen = B;
                }else{
                    Q_curBlockLen = 1;
                }
                for(int j = 0;j < Q_curBlockLen;j++) s.append('Q');
                B = B - Q_curBlockLen;
                startType = 0;//换L来
            }
        }
        System.out.println(s);
    }
    //判断是否可以构成合法字符串
    public static boolean check(int type,int A,int B,int totalBlocks){
        int need_L,need_Q;
        //如果先放L
        if(type == 0){
            need_L = (totalBlocks+1)/2;
            need_Q = totalBlocks/2;

        }else{
            need_L = totalBlocks/2;
            need_Q = (totalBlocks+1)/2;
        }
        if(need_L > A || need_Q > B) return false;
        //当不需要放入，但是确有字母时
        if(need_L == 0 && A > 0) return false;
        if(need_Q == 0 && B > 0) return false;
        return true;
    }
}
