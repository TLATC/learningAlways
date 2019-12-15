package com.shawn.learningalways.login.service;

import com.shawn.learningalways.login.model.LoginContext;

/**
 * @ClassName: TicketRepository
 * @Description 登录票据的远程仓库登录接口
 *              可以有多种实现方式，故此定义一个接口
 * @author: Shawn Wu
 * @date: 2019/12/12 20:21
 * @version:
 */
public interface TicketRepository {

    /**
     * @Description 将票据信息添加到远程仓库
     * @param loginContext 登录上下文信息
     * @return
     * @date 2019/12/12 20:23
     * @auther Shawn Wu
     */
    String storage(LoginContext loginContext);

    /**
     * @Description 从远程仓库获取票据
     * @param ticket 票据
     * @return
     * @date 2019/12/12 20:24
     * @auther Shawn Wu
     */
    LoginContext fetch(String ticket);
}
