package mytest.jdk.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @ClassName SocketServer
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/2 16:07
 **/

public class SocketServer2 {
    public static void main(String[] args) throws Exception {

        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        System.out.println("server 一直等待连接到来");

        // 一直等待请求到来
        while (true) {
            //阻塞
            Socket socket = server.accept();
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len, "UTF-8"));

            }
            System.out.println("get message from client : " + stringBuilder);
            inputStream.close();
            socket.close();
        }


    }
}
