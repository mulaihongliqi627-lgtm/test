public class Demo1 {
    private int n;
    public boolean isPowerOfThree(int _n) {
        n = _n;
        int i = 0;
        while (true){
            int ret = (int) Math.pow(3,i);
            if(ret > n) return false;
            if(ret == n) return true;
            i++;
        }
    }

    public static void main(String[] args) {
        boolean ret = new Demo1().isPowerOfThree(1);
        System.out.println(ret);
    }
}
