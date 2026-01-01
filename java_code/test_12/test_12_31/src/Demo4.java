import java.io.*;

public class Demo4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./text.txt");
        InputStream inputStream = new FileInputStream(file);
        try{
            byte[]bytes = new byte[1024];
            while (true){
                int data = inputStream.read(bytes);
                if (data == -1) {
                    break;
                }
                for (int i = 0; i < data; i++) {
                    System.out.printf("0x%X\n", bytes[i]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            // 关闭文件
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main1(String[] args) throws IOException {
        File file = new File("./text.txt");
        InputStream inputStream = new FileInputStream(file);
        while (true){
            int data = inputStream.read();
            if(data == -1){
                break;
            }
            //把读取结果以16进制打印
            System.out.printf("0x%x\n",data);
        }
    }
}
