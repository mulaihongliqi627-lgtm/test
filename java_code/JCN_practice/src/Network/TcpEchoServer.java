package Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket;//ServerSocket对象，用于建立连接
    private ExecutorService service = Executors.newCachedThreadPool();//可缓存的线程池，线程空闲自动回收
    //构造方法，服务器的端口号作为参数
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    //启动TCP服务器
    public void start() throws IOException {
        System.out.println("服务器已启动...");
        //开始处理请求，请求有多个，while循环处理
        while (true){
            //接受请求
            Socket socket = serverSocket.accept();

            //处理请求
            service.submit(()->{
                try {
                    processConnection(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
    public void processConnection(Socket socket) throws IOException {
        //1.打印记录
        System.out.printf("[%s:%d] 客户端上线!\n", socket.getInetAddress(), socket.getPort());
        //2.使用 try-with-resources 自动关闭流和 socket
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
        ){
            while (true){
                if(!scanner.hasNext()){
                    break;//读取不到字节流末尾就一直循环，收到 EOF（文件结束符）返回 false
                }
                //1.获取请求
                String request = scanner.next();
                //2.根据请求计算响应
                String response = process(request);
                //3.把响应写回给客户端
                printWriter.println(response);
                //4.冲刷缓冲区
                printWriter.flush();//防止响应积攒在缓冲区，导致客户端在缓冲区未满时无法第一时间拿到响应
                System.out.printf("[%s:%d] req: %s; resp: %s\n",socket.getInetAddress(), socket.getPort(), request, response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //打印下线记录
                System.out.printf("[%s:%d] 客户端下线!\n", socket.getInetAddress(), socket.getPort());
                //释放Socket资源,显示释放
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //服务器处理逻辑
    public String process(String request){
        return request;//回显服务器，只需原封不动返回
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();//启动服务器
    }
}
