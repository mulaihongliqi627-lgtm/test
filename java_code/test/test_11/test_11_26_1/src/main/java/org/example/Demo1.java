package org.example;

//饿汉模式，类加载时创建实例
class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){};//防止外部类通过类构造方法new出实例

    public static Singleton getInstance(){
        return instance;
    }

}
public class Demo1 {
    public static void main(String[] args) {
        Singleton s1 =  Singleton.getInstance();//创建第一个实例
        Singleton s2 = Singleton.getInstance();//创建第二个实例
        System.out.println(s1.equals(s2));//创建的两个实例都相同
//        Singleton s3 = new Singleton();
//        System.out.println(s3 == s1);
    }
}
