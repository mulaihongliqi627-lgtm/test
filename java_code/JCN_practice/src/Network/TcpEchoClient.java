package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket;
    //包含ip地址和端口号的构造方法
    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
    }
    public void start() throws IOException {
        System.out.println("客户端已启动...");
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream)){
            while (true){
                //1.从控制台读取输入
                System.out.print("-> ");
                String request = scannerConsole.next();//读取输入内容
                //2.构建请求，发送给服务器
                printWriter.println(request);
                printWriter.flush();//冲刷缓冲区

                // 3. 从服务器读取响应
                if (!scannerNetwork.hasNext()) {
                    break;
                }
                String response = scannerNetwork.next();//只读取一个单词
                //4.打印响应
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                System.out.println("客户端已下线");
                socket.close();//释放socket
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
