package netWork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class tcpEchoServer {
    private ServerSocket serverSocket;

    //创建线程池,不设数量上限
    private ExecutorService service = Executors.newCachedThreadPool();

    public tcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    //启动服务器，接受请求
    public void start() throws IOException {
        System.out.println("服务器已启动...");
        //循环读取客户端发来的请求
        while (true){
            //等待接收请求
            Socket socket = serverSocket.accept();
//            processConnection(socket);//处理请求和响应

            //创建Runnable任务，把处理请求的任务发送给线程池
            service.submit(()->{
                processConnection(socket);
            });
        }
    }

    //处理请求
    public void processConnection(Socket socket){
        //使用try自动释放文件句柄，避免没有close导致文件资源泄露
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            //构建输入输出流
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while (true){
                if(!scanner.hasNext()){
                    break;
                }
                String request = scanner.next();
                String response = process(request);

                //返回响应
                printWriter.println(response);
                printWriter.flush();//冲刷缓冲区,防止响应积攒在缓冲区，导致客户端无法接收到
                //打印日志
                System.out.printf("[%s:%d] req: %s, resp: %s\n",
                        socket.getInetAddress(), socket.getPort(), request, response);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                System.out.printf("[%s:%d]客户端已下线",socket.getInetAddress(),socket.getPort());
                socket.close();//释放socket的网络资源，端口号，缓冲区占用内存等。
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    //服务器处理逻辑，回显服务器，只需要返回输入内容即可
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        tcpEchoServer tcpEchoServer = new tcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
