package com.shawn.learningalways.socket.server;

import com.shawn.learningalways.socket.model.SocketConf;
import com.shawn.learningalways.socket.server.service.TradeServerDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SocketServerThread
 * @Description socket
 * @author: Shawn Wu
 * @date: 2020/1/16 16:13
 * @version:
 */
@Component
public class SocketServerThread implements Runnable{

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketServerThread.class);

    /**
     * socket配置类
     */
    @Autowired
    private SocketConf socketConf;
    /**
     * 交易分发
     */
    @Autowired
    private TradeServerDispatcher tradeServerDispatcher;
    /**
     * serverSocket
     */
    private ServerSocket serverSocket;
    /**
     * socket监听启动标志
     */
    private Boolean socketFlag;
    /**
     * 线程池
     */
    private ExecutorService fixedThreadPool;
    /**
     * socket
     */
    private Socket socket;


    /**
     * @Description 接收并处理客户端报文
     * @param
     * @return 
     * @date 2020/1/17 20:47
     * @auther Shawn Wu
     */
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(socketConf.getPort());
            LOGGER.info("socket服务监听启动，端口为：" + socketConf.getPort());
            socketFlag = true;

            // 循环，socket长连接
            while(socketFlag){
                // 阻塞方法，等待接收客户端报文
                socket = serverSocket.accept();
                tradeServerDispatcher.setSocket(socket);

                // 创建一个定长(10)线程池，可控制线程最大并发数，超出的线程会在队列中等待
                fixedThreadPool = new ThreadPoolExecutor(10, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        new CustomizableThreadFactory("socket-thread-"));
                // 启多线程处理socket消息
                fixedThreadPool.execute(tradeServerDispatcher);
            }
        } catch (IOException e) {
            socketFlag = false;
            LOGGER.error("socket服务端监听出现异常", e);
        } finally {
            // 停止死循环
            socketFlag = false;
            // 关闭socket
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    LOGGER.error("应用销毁前，关闭socket出现异常", e);
                }
            }
        }
    }

    /**
     * @Description 应用销毁前，回收资源
     * @param
     * @return 
     * @date 2020/1/17 20:48
     * @auther Shawn Wu
     */
    @PreDestroy
    public void closeResources(){

        // 停止死循环
        socketFlag = false;

        try {
            // 必须新开一个，才能停止accept阻塞方法
            serverSocket = new ServerSocket(socketConf.getPort());
        } catch (IOException e) {
            // 此处有异常是正常的，不予处理
        }

        // 关闭socket
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.error("应用销毁前，关闭socket出现异常", e);
            }
        }

        // 关闭serverSocket
        if(serverSocket != null){
            try {
                serverSocket.close();
            } catch (IOException e) {
                LOGGER.error("应用销毁前，关闭serverSocket出现异常", e);
            }
        }

        // 线程池关闭
        fixedThreadPool.shutdown();
    }
}