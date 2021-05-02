package mytest.jdk.socket;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 1.0
 * @ClassName SocketServer
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/2 16:07
 **/

public class SocketServer3 {
    public static void main(String[] args) throws Exception {

        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        System.out.println("server 一直等待连接到来");

        // 使用多线程来接收请求

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

        // 一直等待请求到来
        while (true) {
            //阻塞
            Socket socket = server.accept();

            //包装成任务给线程池执行：
            Runnable runnable = ()->{
                try(InputStream inputStream = socket.getInputStream()){
                    // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((len = inputStream.read(bytes)) != -1) {
                        stringBuilder.append(new String(bytes, 0, len, "UTF-8"));

                    }
                    System.out.println("get message from client : " + stringBuilder);
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            };
            threadPoolExecutor.execute(runnable);
        }
    }
}
