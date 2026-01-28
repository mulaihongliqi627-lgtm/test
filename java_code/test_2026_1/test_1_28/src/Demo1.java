import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Demo1 {
    private static List<File> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //输入搜索内容： 文件路径 + 文本信息
        System.out.println("请输入你要搜索的文件路径: ");
        String filePath = scanner.next();
        System.out.println("请输入你要搜索的文本内容: ");
        String word = scanner.next();
        //创建File对象，若路径合法则可以创建成功
        File rootFile = new File(filePath);
        //校验路径是否合法
        if(!rootFile.exists() && !rootFile.isDirectory()){
            System.out.println("你输入的目录" + filePath + "不存在或者不是目录!");
            return;
        }
        //校验查找内容合法性
        if(word.isEmpty()){
            System.out.println("查找内容word不能为空!");
            return;
        }
        //已全部输入成功,递归检索
        scanDir(rootFile,word);
        System.out.println("一共检索到" + list.size() + "个符合要求的文本");
    }
    public static void scanDir(File rootFile, String word){
        File[] files = rootFile.listFiles();//把根目录下的文件全部列出,存入数组
        for(File file : files){
            if(file.isDirectory()){
                scanDir(file,word);//是目录，继续递归
            }else if(file.isFile()){
                dealFile(file,word);//找到文件，开始处理
            }

        }
    }
    public static void dealFile(File file , String word){
        //查看是否包含word
        if(file.getName().contains(word)){//file文件名包含查找元素
            System.out.println("是否删除" + file.getAbsolutePath() + "+? Y/N(大小写均可)");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if(input == "Y" || input == "y"){
                //执行删除
                file.delete();
            }else{
                list.add(file.getAbsoluteFile());//把找到的file对象添加到list列表中
                System.out.println("不选择删除");
            }
        }
    }
}