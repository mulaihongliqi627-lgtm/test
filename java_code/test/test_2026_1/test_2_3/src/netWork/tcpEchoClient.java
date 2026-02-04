package netWork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class tcpEchoClient {
    private Socket socket;
    //客户端自动分配空闲端口

    //构造方法
    public tcpEchoClient(String serverIp,int port) throws IOException {
        socket = new Socket(serverIp,port);
    }
    public void start(){
        System.out.println("客户端启动...");
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scannerConsole = new Scanner(System.in);
            while (true){
                //1.从控制台读取输入的内容
                System.out.print("->");
                String request = scannerConsole.next();
                //2.构建请求，发送给服务器
                printWriter.println(request);
                printWriter.flush();
                //3.接受服务器的响应
                if(!scannerNetwork.hasNext()){
                    break;
                }
                String response = scannerNetwork.next();
                //4.打印返回结果
                System.out.println(response);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                System.out.println("客户端已下线!");
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //创建实例
        tcpEchoClient tcpEchoClient = new tcpEchoClient("127.0.0.1",9090);
        //启动客户端
        tcpEchoClient.start();

    }


}
