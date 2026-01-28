import java.io.*;
import java.util.Scanner;

//扫描指定⽬录，并找到名称或者内容中包含指定字符的所有普通⽂件（不包含⽬录）
public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的目录:");
        String basePath = scanner.next();
        System.out.println("请输入要搜索的字符:");
        String word = scanner.next();
        //校验输入是否合法
        File baseFile = new File(basePath);//依据输入路径创建文件
        if(!baseFile.exists() || !baseFile.isDirectory()){//不存在or不是目录
            System.out.println("输入的路径" + basePath + "不存在!");
            return;
        }
        if(word.isEmpty()){
            System.out.println("搜索字符不能为空!");
            return;
        }
        //递归搜索目录
        srcDire(baseFile,word);
    }
    //检索目录中的文件中是否存在目的字符
    public static void srcDire(File baseFile,String word){
        //列出目录中的所有文件
        File[]files = baseFile.listFiles();
        if(files == null || files.length == 0){
            return;
        }
        for(File file : files){//遍历目录下的文件
            if(file.isDirectory()){
                srcDire(file,word);//递归继续搜索
            }else if(file.isFile()){
                dealFile(file,word);//处理文件
            }
        }
    }
    //处理文件
    public static void dealFile(File file,String word){
        //先判断文件名是否包含检索元素
        if(file.getName().contains(word)){
            System.out.println("找到目标文件：" + file.getAbsolutePath());
            return;
        }
        //文件名不包含就去文件内部查找
        StringBuilder content = new StringBuilder();
        //字符流读取文件
        try(Reader reader = new FileReader(file)){
            char[]chars = new char[1024];
            while (true){
                int n = reader.read(chars);//把content内读取的字符写入chars[]数组中,返回读取到的字符个数n
                if(n == -1){
                    break;
                }
                content.append(chars,0,n);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //判断文本中是否存在查找元素
        if(content.indexOf(word) == -1){//找不到
            System.out.println("找到文件内容匹配的结果: " + file.getAbsolutePath());
            return;
        }
    }
}
