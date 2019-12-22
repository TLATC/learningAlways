package com.shawn.learningalways.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @ClassName: EchoMultiServer
 * @Description socket多客户的服务端
 * @author: Shawn Wu
 * @date: 2019/12/22 15:21
 * @version:
 */
@Component
public class EchoMultiServer {

//    @Autowired
//    private SocketProcessor socketProcessor;

    private ServerSocket serverSocket;


    /**
     * @Description 启动服务端口
     * @param port socket服务端口
     * @return
     * @date 2019/12/22 15:23
     * @auther Shawn Wu
     */
    public void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("socket服务监听启动，端口为：" + port);
            // 死循环，一直在等待新的客户端连接, 然后为客户端创建处理线程EchoClientHandler
            while(true){
                /// 方式一：内部类启动线程
//                new EchoClientHandler(serverSocket.accept()).start();

                // 方式二：创建一个定长(10)线程池，可控制线程最大并发数，超出的线程会在队列中等待
                ExecutorService fixedThreadPool = new ThreadPoolExecutor(10, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        new CustomizableThreadFactory("socket-thread-"));
//                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10, new CustomizableThreadFactory("socket-thread-"));
                SocketProcessor socketProcessor = new SocketProcessor();
                socketProcessor.setSocket(serverSocket.accept());
                fixedThreadPool.execute(socketProcessor);
                // todo: 线程池的关闭
//                fixedThreadPool.shutdown();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 关闭socket服务
     * @param
     * @return
     * @date 2019/12/22 15:24
     * @auther Shawn Wu
     */
    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 静态内部类，管理每一个客户端的连接
     * @param
     * @return 
     * @date 2019/12/22 15:25
     * @auther Shawn Wu
     */
    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("当前线程id为："+Thread.currentThread().getId());
                System.out.println("线程名为："+Thread.currentThread().getName());

                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                // 对输入内容的应答
                // .表示结束，否则一直将输入重新输出
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("收到客户端的消息：" + inputLine);
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}