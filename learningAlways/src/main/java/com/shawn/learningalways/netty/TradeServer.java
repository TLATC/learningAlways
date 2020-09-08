package com.shawn.learningalways.netty;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * TradeServer
 * netty服务端
 *
 * @author Shawn Wu
 * @date 2020/9/8 19:09
 * @since x
 */
@Component
public class TradeServer implements SmartLifecycle{
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServer.class);

    /**
     * netty配置类
     */
    @Autowired
    private NettyYmlProperties nettyYmlProperties;
    /**
     * 是否运行（true为运行，false为停止）
     */
    private boolean runningFlag = false;

    /**
     * 是否自动执行start方法
     * @return true为自动执行，false不自动执行
     */
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    /**
     * 销毁事件
     *
     * 该方法只对直接实现接口SmartLifecycle的类才起作用
     * @param runnable runnable
     */
    @Override
    public void stop(Runnable runnable) {
        runningFlag = false;
    }

    /**
     * 启动事件
     *
     * 当同时满足以下条件时，才会执行：
     * （1）isAutoStartup()方法返回true
     * （2）上下文被刷新（所有对象已被实例化和初始化之后）
     * （3）isRunning()方法返回false
     */
    @Override
    public void start() {
        runningFlag = true;
        startServer();
    }

    /**
     * 销毁事件
     * 该方法只对直接实现接口Lifecycle的类才起作用
     */
    @Override
    public void stop() {}

    /**
     * 是否正在执行
     * @return true为正在执行，此状态时才能执行stop方法；
     *         false为不在执行，此状态时才能执行start方法
     */
    @Override
    public boolean isRunning() {
        return false;
    }

    /**
     * 如果工程中有多个实现接口SmartLifecycle的类，则这些类的start的执行顺序按getPhase方法返回值从小到大执行;
     * stop执行顺序相反，返回值大的先执行
     * @return 执行优先级
     */
    @Override
    public int getPhase() {
        return 0;
    }


    public void startServer(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        // todo

        LOGGER.info("netty服务端启动，端口为：{}", nettyYmlProperties.getServerPort());
    }
}
