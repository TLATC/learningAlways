package com.shawn.learningalways.base.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RedisUtil
 * redis工具类
 *
 * @author Shawn Wu
 * @date 2020/9/26 17:08
 * @since v1
 */
@Component
public class RedisUtil {

    private final RedisTemplate<String, String> redisTemplate;

    /**
     * 私有构造方法
     */
    @Autowired
    private RedisUtil(RedisTemplate<String, String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    /**
     * 统计bitmap某个key中，bit位为1的总数
     *
     * @param key key值
     * @return bit位为1的总数
     * @date 2020/9/26 17:13
     * @author Shawn Wu
     */
    public long bitCount(String key){
        return redisTemplate.execute((RedisCallback<Long>) redisConnection -> redisConnection.bitCount(key.getBytes()));
    }
}