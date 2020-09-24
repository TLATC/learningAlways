package com.shawn.learningalways.base.conf.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * NettyYmlProperties
 * netty配置类，与yml文件中对应 todo:yml飘黄处理
 *
 * @author Shawn Wu
 * @date 2020/9/8 19:34
 * @since x
 */
@Component
public class NettyYmlProperties {

    /**
     * netty服务端的ip
     */
    @Value("${netty.serverIp}")
    private String serverIp;
    /**
     * netty服务端的端口
     */
    @Value("${netty.serverPort}")
    private Integer serverPort;
    /**
     * netty客户端的端口
     */
    @Value("${netty.clientPort}")
    private Integer clientPort;
    /**
     * 消息编码格式
     */
    @Value("${netty.encoding}")
    private String encoding;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getClientPort() {
        return clientPort;
    }

    public void setClientPort(Integer clientPort) {
        this.clientPort = clientPort;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
