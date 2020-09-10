package com.shawn.learningalways.socket.server;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.shawn.learningalways.socket.model.SocketConf;
import com.shawn.learningalways.socket.server.service.TradeServerDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SocketServerThread
 * @Description socket服务端线程
 *              使用netty更好，见netty目录
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

            // 获取操作系统的cpu核心数
            int cpuCount = Runtime.getRuntime().availableProcessors();
            // 此处业务基本是cpu密集的，故核心线程数和最大线程数设置较多
            int corePoolSize = cpuCount * 2;
            int maximumPoolSize = cpuCount * 3;
            // 等待队列的最大长度
            int capacity = cpuCount * 2;
            // 线程池名
            String threadNamePrefix = "socket-thread-";
            fixedThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(capacity),
                    new CustomizableThreadFactory(threadNamePrefix));
						
            // 循环，socket长连接
            while(socketFlag){
                // 阻塞方法，等待接收客户端报文
                socket = serverSocket.accept();

                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                } catch (IOException e) {
                    LOGGER.error("从socket中读取输入流异常", e);
                }
                // 获取到的报文消息
                String xmlContent = getSocketXmlContent(inputStream);
                LOGGER.debug("收到交易请求，请求报文为：{}", xmlContent);

                TradeServerDispatcher tradeServerDispatcher = new TradeServerDispatcher();
                tradeServerDispatcher.setSocketMsg(xmlContent);
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
     * @Description 获取socket报文中的正文内容
     * @param is socket输入流
     * @return 正文内容
     * @date 2020/1/17 21:14
     * @auther Shawn Wu
     */
    private String getSocketXmlContent(InputStream is){
        // 固定前8位是报文体长度
        byte[] buffer = new byte[8];
        int len = 0;
        try {

            is.read(buffer);
            int contentLength = Integer.parseInt(new String(buffer, 0, 8));
            LOGGER.debug("收到的报文长度为：{}", contentLength);

            // 获取报文内容
            buffer = new byte[contentLength];
            len = -1;
            len = is.read(buffer);
            // -1说明没有输入输出内容，是客户端的连接或断开
            if(len < 0){
                return "";
            }
        } catch (IOException e) {
            LOGGER.error("从socket中读取报文内容异常", e);
        }
        return new String(buffer, 0, len);
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