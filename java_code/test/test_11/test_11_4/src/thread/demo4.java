package thread;

public class demo4 {
    public static void main(String[] args) {
        //创建一个匿名内部类的实例
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("hello cheems");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t = new Thread(runnable);//把这个实例作为参数传给Thread（）
        t.start();
        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
