import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file = new File("D:/code/ideaPrograms/java_steins_gate/java_code/test_12/test_12_31/text.txt");
        //获取当前文件所在的目录
        System.out.println(file.getParent());
        //获取当前文件的文件名
        System.out.println(file.getName());
        //获取文件的实现类
        System.out.println(file.getClass());
        //判断当前文件是否存在
        System.out.println(file.exists());

    }
}