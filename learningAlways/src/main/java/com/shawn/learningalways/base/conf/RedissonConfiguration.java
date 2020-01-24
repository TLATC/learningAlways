package com.shawn.learningalways.base.conf;

import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import com.shawn.learningalways.base.conf.model.RedisProperties;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RedissonConfiguration
 * @Description redisson分布式锁配置
 * @author: Shawn Wu
 * @date: 2020/1/24 16:21
 * @version:
 */
@Configuration
public class RedissonConfiguration {

    /**
     * redis配置
     */
    @Autowired
    private RedisProperties redisProperties;


    /**
     * @Description 单机模式自动装配
     * @param
     * @return
     * @date 2020/1/24 16:27
     * @auther Shawn Wu
     */
    @Bean
    public RedissonClient redissonSingle(){
        Config config = new Config();
        // 配置redis地址
        String redisAddress = "redis://" + redisProperties.getHost()
                + ":" +redisProperties.getPort();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redisAddress);
//        .setAddress(redis://10.18.75.115:6379)
        // 配置redis密码
        if(StringUtils.isNotBlank(redisProperties.getPassword())) {
            serverConfig.setPassword(redisProperties.getPassword());
        }

        return Redisson.create(config);
    }
}