package com.shawn.learningalways.login;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.shawn.learningalways.login.model.LoginContext;

/**
 * @ClassName: LoginContextHolder
 * @Description 登录信息本地存储器，提供工具方法
 * @author: Shawn Wu
 * @date: 2019/12/14 16:39
 * @version:
 */
public class LoginContextHolder {

    /**
     * 保存登录信息的本地线程
     * TransmittableThreadLocal可以在异步方法中获取到
     */
    private static final ThreadLocal<LoginContext> THREAD_LOCAL = new TransmittableThreadLocal<>();


    /**
     * @Description 从本地线程获取当前登录人信息
     * @param
     * @return
     * @date 2019/12/14 17:02
     * @auther Shawn Wu
     */
    public static LoginContext getLoginContext(){
        return THREAD_LOCAL.get();
    }

    /**
     * @Description 把登录人信息保存到本地线程中
     *              限制为包私有方法
     * @param loginContext 当前登录人信息
     * @return 
     * @date 2019/12/14 17:06
     * @auther Shawn Wu
     */
    static void addLoginContext(LoginContext loginContext){
        THREAD_LOCAL.set(loginContext);
    }

    /**
     * @Description 移除本地线程中的数据
     *              限制为包私有方法
     * @param
     * @return
     * @date 2019/12/14 17:54
     * @auther Shawn Wu
     */
    static void remove(){
        THREAD_LOCAL.remove();
    }
}