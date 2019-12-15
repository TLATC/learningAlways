package com.shawn.learningalways.login.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.login.model.LoginContext;
import com.shawn.learningalways.login.service.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisTicketRepository
 * @Description 登录票据的远程仓库接口--通过redis实现
 * @author: Shawn Wu
 * @date: 2019/12/12 20:29
 * @version:
 */
@Component
public class RedisTicketRepository implements TicketRepository{

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 默认的登录有效期时间
     */
    private static final Long DEFAULT_LOGIN_EXPIRE_HOUR = 24L;

    /**
     * @Description 将登陆信息保存到redis中
     * @param loginContext 当前登录人信息
     * @return ticket 登陆票据
     * @date 2019/12/12 20:50
     * @auther Shawn Wu
     */
    @Override
    public String storage(LoginContext loginContext) {
        if(loginContext == null){
            throw new CommonException("要添加的登录信息不能为空");
        }
        String ticket = UUID.randomUUID().toString().replaceAll("-", "");
        stringRedisTemplate.opsForValue().set(ticket, JSON.toJSONString(loginContext), DEFAULT_LOGIN_EXPIRE_HOUR, TimeUnit.HOURS);
        return ticket;
    }

    /**
     * @Description 根据票据，从redis获取当前登录人信息
     * @param ticket 票据
     * @return loginContext 当前登录人信息
     * @date 2019/12/14 16:16
     * @auther Shawn Wu
     */
    @Override
    public LoginContext fetch(String ticket) {
        if(StringUtils.isEmpty(ticket)){
            throw new CommonException("票据不能为空");
        }
        String loginContextString = stringRedisTemplate.opsForValue().get(ticket);
        if(StringUtils.isEmpty(loginContextString)){
            throw new CommonException("根据票据，获取不到当前登录人信息");
        }
        LoginContext loginContext = JSON.parseObject(loginContextString, LoginContext.class);
        // 更新当前登录人失效时间
        stringRedisTemplate.expire(ticket, DEFAULT_LOGIN_EXPIRE_HOUR, TimeUnit.HOURS);
        return loginContext;
    }
}