package com.shawn.learningalways.login;

import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.login.model.LoginContext;
import com.shawn.learningalways.login.service.impl.RedisTicketRepository;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: LoginAspect
 * @Description 登录拦截类
 * @author: Shawn Wu
 * @date: 2019/12/14 16:38
 * @version:
 */
@Aspect
@Component
public class LoginAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAspect.class);

    @Autowired
    private RedisTicketRepository redisTicketRepository;


    /**
     * @Description 拦截指定目录下的请求，进行票据校验
     * @param joinPoint
     * @return 
     * @date 2019/12/14 18:09
     * @auther Shawn Wu
     */
    @Around(value = "execution(public * com.shawn.learningalways.logintest.controller.*.*(..))")
    public Object loginCheck(ProceedingJoinPoint joinPoint){
        ServletRequestAttributes ra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ra.getRequest();
        String ticket = request.getHeader("ticket");
        if(StringUtils.isEmpty(ticket)){
            throw new CommonException("ticket不能为空");
        }
        // 获取当前登录人信息
        LoginContext loginContext = redisTicketRepository.fetch(ticket);
        if(loginContext == null){
            throw new CommonException("根据ticket未获取到登录人信息");
        }
        // 将当前登录人信息保存到本地线程中
        LoginContextHolder.addLoginContext(loginContext);
        // 执行切面内方法
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            LOGGER.error("方法执行异常", throwable);
        }
        // 清除本地线程中的登录信息
        LoginContextHolder.remove();
        return result;
    }

}