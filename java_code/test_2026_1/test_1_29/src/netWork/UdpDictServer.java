package netWork;

import netWork.UdpEchoServer;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        dict.put("hello", "你好");
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("pig", "小猪");
    }

    // 重写 process

    @Override
    public String process(String request) {
        // 实现英文 -> 中文
        return dict.getOrDefault(request, "[没有找到该单词]");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
