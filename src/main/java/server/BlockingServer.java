package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingServer {
    public static void main(String[] args) throws IOException {
        BlockingServer blockingServer = new BlockingServer();
        blockingServer.run();
    }

    private void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9899);
        System.out.println("접속 대기중");

        while (true) {
            Socket sock = serverSocket.accept();
            System.out.println("클라이언트 연결됨");

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            while (true) {
                try {
                    int request = in.read();
                    out.write(request);
                } catch (IOException e) {
                    break;
                }
            }
        }
    }
}
