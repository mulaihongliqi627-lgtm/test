package thread;

//饿汉模式
class Singleton{
    private static Singleton instance = new Singleton();
    private Singleton(){};//构造方法，private限制类外不能new出实例
    public static Singleton getInstance(){
        return instance;
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
//        Singleton s3 = new Singleton();
        System.out.println(s1 == s2);//结果为true，说明两次创建的实例相同
    }
}
