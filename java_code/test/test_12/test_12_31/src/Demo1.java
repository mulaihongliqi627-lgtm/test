import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) {
        File file1 = new File("src/hello.txt");
        try{
            if(file1.createNewFile()){
                System.out.println(file1.getName() + "已创建");
            }else{
                System.out.println("文件已存在，" + "路径为：" + file1.getPath());
            }
            //判断创建的是否是文件
            System.out.println(file1.isFile());
            //判断创建的是否是目录
            System.out.println(file1.isDirectory());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
