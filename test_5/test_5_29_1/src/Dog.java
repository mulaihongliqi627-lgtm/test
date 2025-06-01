public class Dog {
    //成员变量
    public String name;//狗的名字
    public String gender;//狗的性别
    public String color;//狗的毛色
    public String variety;//狗的品种
    public void sleep(){
        System.out.println(name+"在睡觉。。");
    }
    public void bark(){
        System.out.println(name+"在叫。。");
    }
    public void eat(){
        System.out.println(name+"嚼嚼嚼。。");
    }

    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.name="cheems";
        System.out.println(dog.name);
    }
}


