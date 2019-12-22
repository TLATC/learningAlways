package com.shawn.learningalways.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName: EchoClient
 * @Description socket客户端
 * @author: Shawn Wu
 * @date: 2019/12/22 15:33
 * @version:
 */
public class EchoClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    /**
     * @Description 开启socket连接
     * @param ip socket服务端ip
     * @param port socket服务端端口
     * @return 
     * @date 2019/12/22 15:37
     * @auther Shawn Wu
     */
    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 发送socket消息
     * @param msg 消息内容
     * @return
     * @date 2019/12/22 15:38
     * @auther Shawn Wu
     */
    public String sendMessage(String msg) {
        out.println(msg);
        String resp = null;
        try {
            resp = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * @Description 关闭socket连接
     * @param
     * @return
     * @date 2019/12/22 15:38
     * @auther Shawn Wu
     */
    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}