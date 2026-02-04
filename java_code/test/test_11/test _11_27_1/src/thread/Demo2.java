package thread;

class Singletonlazy{
    private static volatile Object locker = new Object();
    private static Singletonlazy instance = null;
    private Singletonlazy(){

    };
    public static Singletonlazy getInstance(){
        if(instance == null){//判断是否要产生锁竞争
            synchronized (locker) {//加锁，使得if判断和new操作原子化
                if (instance == null) {//判断是否要创建实例
                    instance = new Singletonlazy();
                }
            }
        }
        return instance;
    }
}
public class Demo2 {
    public static void main(String[] args) {

    }
}
