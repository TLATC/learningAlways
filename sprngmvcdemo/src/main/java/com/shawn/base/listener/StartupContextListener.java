package com.shawn.base.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * @ClassName: StartupContextListener
 * @Description 启动监听器
 * @author: Shawn Wu
 * @date: 2019/1/31 17:19
 * @version:
 */
public class StartupContextListener extends ContextLoaderListener {

    /**
     * 容器启动，就会调用contextInitialized方法
     * @param arg0
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {

    }
}