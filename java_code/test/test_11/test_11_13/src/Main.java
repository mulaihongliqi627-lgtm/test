public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("hello thread");
        });
        t.getState();
    }
}