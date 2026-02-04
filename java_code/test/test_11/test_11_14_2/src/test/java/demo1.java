class Singleton{
    private static Singleton instance = new Singleton();
    private Singleton(){}//private保证构造方法不能被类外访问，保证只能创建出一个实例
    public static Singleton getInstance(){//外部调用getInstance才会创建实例
        return instance;
    }
}
public class demo1 {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();//尝试new出一个实例就会报错
        Singleton instance = Singleton.getInstance();//正确创建实例

    }
}
