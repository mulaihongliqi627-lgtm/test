package thread;

public class dmeo3 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个匿名内部类
        Thread t = new Thread(){
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
        t.start();
        while (true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }

    }
}
