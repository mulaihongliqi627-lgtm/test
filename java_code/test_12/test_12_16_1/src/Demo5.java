import java.math.BigInteger;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long aInput = sc.nextLong();
        long bInput = sc.nextLong();
        if(aInput == 1){
            System.out.println(1);
            return;
        }
        if(bInput >= 31){
            System.out.println(-1);
            return;
        }
        BigInteger s = BigInteger.valueOf(aInput);
        BigInteger ret = s.pow((int)bInput);
        BigInteger limit = BigInteger.valueOf((long) Math.pow(10,9));
        if(ret.compareTo(limit) > 0){
            System.out.println(-1);
        }else{
            System.out.println(ret);
        }
    }
}
