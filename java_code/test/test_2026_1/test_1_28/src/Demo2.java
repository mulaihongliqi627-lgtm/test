import java.io.*;
import java.util.Scanner;

//字节流实现文件拷贝
public class Demo2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件路径:");
        String srcPath = scanner.next();
        System.out.println("请输入拷贝目标文件路径:");
        String destPath = scanner.next();
        //校验输入内容是否合法
        File srcFile = new File(srcPath);
        if(!srcFile.isFile() || !srcFile.exists()){
            System.out.println("拷贝的源文件" + srcFile.getAbsolutePath() + "不存在");
            return;
        }
        File destFile = new File(destPath);//创建目标文件对象
        File destFileParent = new File(destPath);
        if(!destFileParent.isDirectory() || !destFileParent.exists()){
            System.out.println("拷贝的文件所在目录" + destFileParent.getAbsolutePath() + "不存在");
            return;
        }

        //使用try,避免文件句柄溢出异常。也可使用final释放文件资源
        try(InputStream inputStream = new FileInputStream(srcFile);
        OutputStream outputStream = new FileOutputStream(destFileParent)){
            while (true){//循环读取
                int n = inputStream.read();//读取到的字节个数
                if(n == -1){//读取到文件末尾
                    break;
                }
                //开始拷贝
                byte[]arr = new byte[1024];
                outputStream.write(arr,0,n);//把字节数组通过输出流写入文件
            }

        }

    }
}
