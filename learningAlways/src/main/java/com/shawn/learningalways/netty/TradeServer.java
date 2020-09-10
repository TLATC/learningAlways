package com.shawn.learningalways.netty;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServer.class);

    /**
     * netty配置类
     */
    private final NettyYmlProperties nettyYmlProperties;
    /**
     * netty交易服务端初始化类
     */
    private final TradeServerInitializer tradeServerInitializer;

    /**
     * 是否运行（true为运行，false为停止）
     */
    private boolean runningFlag = false;
    /**
     * boss用来接收进来的连接；
     * worker用来处理已经被接收的连接
     */
    private EventLoopGroup boss, worker;
    /**
     * netty的异步结果类
     */
    private ChannelFuture cf;

    /**
     * 构造方法注入
     * @param nettyYmlProperties netty配置类
     * @param tradeServerInitializer netty交易服务端初始化类
     */
    @Autowired
    public TradeServer(NettyYmlProperties nettyYmlProperties, TradeServerInitializer tradeServerInitializer) {
        this.nettyYmlProperties = nettyYmlProperties;
        this.tradeServerInitializer = tradeServerInitializer;
    }


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
        // 关闭netty服务
        stopServer();
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
        // 启动netty服务端
        startServer();
    }

    /**
     * 销毁事件
     * 该方法只对直接实现接口Lifecycle的类才起作用，本类并不生效
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
        return runningFlag;
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


    /**
     * 启动netty服务端
     *
     * @date 2020/9/10 14:13
     * @author Shawn Wu
     */
    private void startServer(){
        // NioEventLoopGroup是用来处理IO操作的多线程事件循环器 todo:为啥是1
        boss = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();

        // ServerBootstrap是一个启动NIO服务的辅助启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                // 用来处理客户端的请求
                .childHandler(tradeServerInitializer)
                .option(ChannelOption.SO_BACKLOG, 1024);

        // 绑定端口，开始接收进来的连接
        try {
            cf = serverBootstrap.bind(nettyYmlProperties.getServerPort()).sync();
        } catch (InterruptedException e) {
            LOGGER.error("netty服务端绑定端口异常", e);
        }

        LOGGER.info("netty服务端启动成功，端口为：{}", nettyYmlProperties.getServerPort());
    }

    /**
     * 关闭netty服务端
     *
     * @date 2020/9/10 14:18
     * @author Shawn Wu
     */
    private void stopServer(){
        cf.channel().close();
        boss.shutdownGracefully();
        worker.shutdownGracefully();
        LOGGER.info("netty服务端关闭成功");
    }

}
