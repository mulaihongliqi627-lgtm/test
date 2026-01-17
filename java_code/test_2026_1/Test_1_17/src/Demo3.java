import java.io.File;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        //不是真正在对应的硬盘区域创建一个文件，只是创建一个路径对象
        File file1 = new File("D:/code/ideaPrograms/java_steins_gate/java_code/test_2026_1/Test_1_17/src/test");
        //创建一个真实的文件,路径为file的绝对路径
        try{
            file1.createNewFile();
            if(file1.exists()){
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
