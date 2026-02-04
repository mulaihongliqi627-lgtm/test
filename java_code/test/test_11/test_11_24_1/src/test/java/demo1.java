import java.util.Scanner;

public class demo1 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            if(i % 5 == 0) {
                System.out.println();  // 只换行，不重复输出数字
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 2){
            System.out.println("yes");
            return;
        }
        for(int i = 2; i<= n-1;i++){
            if(n % i == 0){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
