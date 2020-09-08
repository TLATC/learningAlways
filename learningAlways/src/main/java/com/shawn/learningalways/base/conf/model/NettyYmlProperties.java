package com.shawn.learningalways.base.conf.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * NettyYmlProperties
 * netty配置类，与yml文件中对应
 *
 * @author Shawn Wu
 * @date 2020/9/8 19:34
 * @since x
 */
@Component
public class NettyYmlProperties {

    /**
     * netty服务端的端口
     */
    @Value("${netty.serverPort}")
    private String serverPort;

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }
}
