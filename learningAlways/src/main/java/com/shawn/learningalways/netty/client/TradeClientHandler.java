package com.shawn.learningalways.netty.client;

import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * TradeClientHandler
 * netty交易客户端事件处理类
 *
 * @author Shawn Wu
 * @date 2020/9/18 15:34
 * @since v1
 */
public class TradeClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeClientHandler.class);

    /**
     * netty交易服务事件处理类
     */
    private NettyYmlProperties nettyYmlProperties;
    /**
     * 交易报文
     */
    private String tradeMsg;

    TradeClientHandler(NettyYmlProperties nettyYmlProperties, String tradeMsg) {
        this.nettyYmlProperties = nettyYmlProperties;
        this.tradeMsg = tradeMsg;
    }


    /**
     * 在到服务器的连接已经建立之后将被调用
     * todo：netty系统学习，发送消息的职责链？
     * todo: 每次都new一个，通过此方式发消息？
     *
     * @param ctx 应用上下文
     * @date 2020/9/24 18:52
     * @author Shawn Wu
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        // 将String转化为ByteBuf对象，并发送消息
        ctx.writeAndFlush(Unpooled.copiedBuffer(tradeMsg, CharsetUtil.UTF_8));
    }

    /**
     * 接收上下文传来的消息
     *
     * @param ctx 上下文
     * @param msg 消息
     * @date 2020/9/18 15:52
     * @author Shawn Wu
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 如果初始化消息通道时没有加解码器，那么这里接收到的就是ByteBuf
        ByteBuf buffer = (ByteBuf) msg;
        String reqString = buffer.toString(Charset.forName(nettyYmlProperties.getEncoding()));
        LOGGER.debug("收到了服务端返回的消息，内容为： {}", reqString);
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
        LOGGER.error("netty客户端处理消息异常", cause);
    }
}