import java.io.File;
import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("./text.txt");
//        System.out.println(file.exists());
        String[]list = file.list();
        System.out.println(Arrays.toString(list));
        System.out.println(list.length);
        File []listFiles = file.listFiles();
        System.out.println(Arrays.toString(listFiles));

    }
}
