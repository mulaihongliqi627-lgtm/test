package netWork;

import java.io.IOException;

public class tcpDictClient extends tcpEchoClient{
    public tcpDictClient(String serverIp, int port) throws IOException {
        super(serverIp, port);
    }

    public static void main(String[] args) throws IOException {
        tcpEchoClient  client = new tcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
