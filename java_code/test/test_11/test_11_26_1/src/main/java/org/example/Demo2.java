package org.example;

class Singletonlazy{
    private static Object locker = new Object();
    private static volatile Singletonlazy instance = null;
    private Singletonlazy(){

    }
    public static Singletonlazy getInstance(){
        if(instance == null){//判断是否已经创建了实例，没有创建就加锁
            synchronized (locker){//加锁使得创建实例原子化
                if(instance == null){
                    instance = new Singletonlazy();
                }
            }
        }
        return instance;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Singletonlazy s1 = Singletonlazy.getInstance();
        Singletonlazy s2 = Singletonlazy.getInstance();
        System.out.println(s1 == s2);
    }

}
