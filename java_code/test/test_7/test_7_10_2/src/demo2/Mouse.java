package demo2;

public class Mouse implements USB{

    @Override
    public void poweron() {
        System.out.println("使用鼠标服务");
    }

    @Override
    public void poweroff() {
        System.out.println("关闭鼠标服务");
    }
}
