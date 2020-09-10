package com.shawn.learningalways.netty;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * TradeServerHandler
 * netty交易服务事件处理类
 *
 * @author Shawn Wu
 * @date 2020/9/10 13:40
 * @since x
 */
@Component
public class TradeServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServerHandler.class);

    /**
     * netty配置文件类
     */
    private final NettyYmlProperties nettyYmlProperties;

    /**
     * 构造方法注入
     * @param nettyYmlProperties netty配置文件类
     */
    @Autowired
    public TradeServerHandler(NettyYmlProperties nettyYmlProperties) {
        this.nettyYmlProperties = nettyYmlProperties;
    }


    /**
     * 接收上下文传来的消息
     *
     * @param ctx 上下文
     * @param msg 消息
     * @date 2020/9/10 17:06
     * @author Shawn Wu
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        String reqString = buffer.toString(Charset.forName(nettyYmlProperties.getEncoding()));
        LOGGER.debug("收到了来自客户端的消息，内容为： {}", reqString);

        // todo: 此处可以增加处理消息的业务逻辑
    }

    /**
     * 出现异常时触发
     *
     * @param ctx 上下文
     * @param cause 异常
     * @date 2020/9/10 14:40
     * @author Shawn Wu
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("netty服务端处理消息异常", cause);
    }
}