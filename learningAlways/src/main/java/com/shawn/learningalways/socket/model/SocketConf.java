package com.shawn.learningalways.socket.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SocketConf
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/16 21:41
 * @version:
 */
@Component
public class SocketConf {

    /**
     * socket服务端口
     */
    @Value("${socket.port}")
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}