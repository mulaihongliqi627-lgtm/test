package demo2;

public class KeyBoard implements USB{

    @Override
    public void poweron() {
        System.out.println("启动键盘");
    }

    @Override
    public void poweroff() {
        System.out.println("关闭键盘");

    }
}
