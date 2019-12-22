package com.shawn.learningalways.socket;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName: SocketProcessor
 * @Description socket内容处理
 * @author: Shawn Wu
 * @date: 2019/12/22 16:17
 * @version:
 */
@Component
public class SocketProcessor implements Runnable{

    /**
     * socket对象
     */
    private Socket socket;

    /**
     * 给socket对象赋值
     * @param socket
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    /**
     * @Description socket内容处理
     * @param
     * @return
     * @date 2019/12/22 16:20
     * @auther Shawn Wu
     */
    @Override
    public void run() {
        // 假定报文长度不超过1024字节
        byte[] bytes = new byte[1024];

        // 读取socket消息内容
        try {
            InputStream is = socket.getInputStream();
            is.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("当前线程id为：" + Thread.currentThread().getId());
        System.out.println(", 线程名为：" + Thread.currentThread().getName());

        String inputContent = new String(bytes);
        System.out.println("收到的socket消息内容是：" + inputContent);

        // 返回socket结果
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}