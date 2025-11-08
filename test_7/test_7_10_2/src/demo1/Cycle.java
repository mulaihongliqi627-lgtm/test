package demo1;

public class Cycle implements IShape {

    @Override
    public void poweron() {
        System.out.println("开机");
    }

    @Override
    public void poweroff() {
        System.out.println("关机");
    }
}
