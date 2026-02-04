package netWork;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

//字典服务器
public class tcpDictServer extends tcpEchoServer{
    Map<String,String> Dictionary = new HashMap<>();
    public tcpDictServer(int port) throws IOException {
        super(port);
        //给字典中添加数据
        Dictionary.put("cat","哈基米");
        Dictionary.put("dog","大狗");
        Dictionary.put("hello","你好");
        Dictionary.put("future","未来");
        Dictionary.put("world","世界");
        Dictionary.put("Alice","爱丽丝");
    }

    @Override
    public String process(String request) {
        return Dictionary.getOrDefault(request,"字典中不存在该单词!");
    }

    public static void main(String[] args) throws IOException {
        tcpDictServer server = new tcpDictServer(9090);
        server.start();
    }
}
