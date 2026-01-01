import java.io.File;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        File file1 = new File("./1.txt");
//        boolean result =  file1.delete();
//        System.out.println(result);
        //延迟删除，main线程结束之后删除
        file1.deleteOnExit();
        Scanner sc = new Scanner(System.in);
        System.out.print("输入任意内容:");
        sc.next();
        System.out.println(file1.exists());
    }
}
