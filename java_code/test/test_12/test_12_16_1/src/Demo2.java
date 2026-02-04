public class Demo2 {
    private static Object locker = new Object();
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        synchronized (locker){//加锁
            for(int i = 0;i < 10;i++){
                sb.append(i);
                sb.append('A');
            }
        }//解锁
    }
}
