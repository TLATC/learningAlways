package com.shawn.learningalways.base.conf.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisConfEO
 * @Description redis配置类
 * @author: Shawn Wu
 * @date: 2020/1/24 16:18
 * @version:
 */
@Component
public class RedisProperties {

    /**
     * 主机地址
     */
    @Value("${spring.redis.host}")
    private String host;

    /**
     * 端口
     */
    @Value("${spring.redis.port}")
    private String port;

    /**
     * 密码
     */
    @Value("${spring.redis.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }
}