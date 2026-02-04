public static void move(int n,char pos1,char pos2){
        System.out.print(pos1+"->"+pos2+' ');
        }
//pos1是起始盘子，pos2是中转盘子，pos3是目的盘子
public static void hanoi(int n,char pos1,char pos2,char pos3){
        if(n==1){
        move(1,pos1,pos3);
        return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(n-1,pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);

        }

public static void main(String[] args) {
        hanoi(3,'A','B','C');
        }
        }