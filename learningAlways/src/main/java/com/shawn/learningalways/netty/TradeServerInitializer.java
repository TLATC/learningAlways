package com.shawn.learningalways.netty;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import com.shawn.learningalways.socket.server.service.impl.GetAgentChatInfoStrategy;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * TradeServerInitializer
 * netty交易服务端初始化类
 * 用来增加多个处理类到ChannelPipeline上，包括编码、解码等
 *
 * @author Shawn Wu
 * @date 2020/9/10 11:48
 * @since x
 */
@Component
public class TradeServerInitializer extends ChannelInitializer<SocketChannel>{

    /**
     * netty交易服务事件处理类
     */
    private final NettyYmlProperties nettyYmlProperties;

    private final GetAgentChatInfoStrategy getAgentChatInfoStrategy;

    /**
     * 构造方法注入
     * @param tradeServerHandler netty交易服务事件处理类
     */
    @Autowired
    public TradeServerInitializer(NettyYmlProperties nettyYmlProperties, GetAgentChatInfoStrategy getAgentChatInfoStrategy) {
        this.nettyYmlProperties = nettyYmlProperties;
        this.getAgentChatInfoStrategy = getAgentChatInfoStrategy;
    }

    /**
     * 初始化消息通道
     *
     * @param socketChannel socketChannel
     * @date 2020/9/10 13:21
     * @author Shawn Wu
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 设置交易的业务处理类（注意，此处必须new新实例）
        pipeline.addLast(new TradeServerHandler(nettyYmlProperties, getAgentChatInfoStrategy));
    }
}