package com.shawn.learningalways.netty.server;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import com.shawn.learningalways.base.util.SpringUtils;
import com.shawn.learningalways.netty.model.Trade;
import com.shawn.learningalways.netty.service.TradeServerStrategy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import reactor.core.support.Assert;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * TradeServerHandler
 * netty交易服务事件处理类
 * 由于初始化消息通道时此类必须new出来，所以不托管于spring
 *
 * @author Shawn Wu
 * @date 2020/9/10 13:40
 * @since v1
 */
public class TradeServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServerHandler.class);

    /**
     * netty交易服务事件处理类
     */
    private NettyYmlProperties nettyYmlProperties;

    TradeServerHandler(NettyYmlProperties nettyYmlProperties) {
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
        // 如果初始化消息通道时没有加解码器，那么这里接收到的就是ByteBuf
        ByteBuf buffer = (ByteBuf) msg;
        String reqString = buffer.toString(Charset.forName(nettyYmlProperties.getEncoding()));
        LOGGER.debug("收到了来自客户端的消息，内容为： {}", reqString);

        /*
         * 实际看业务场景需求，此处以固定长度报文的格式为例。但实际并没处理半包粘包的问题
         * 约定好报文的前8位，表示后续实际报文的长度，记为len
         * todo: 实际上要考虑半包粘包等问题，若接收到的实际报文长度不满len，则暂时缓存下来，直到满了才是一次完成的请求
         *       还有集群环境下的消息处理问题
         */
        reqString = reqString.substring(8, reqString.length());
        // 转化为约定好的报文体格式对应的交易类
        Trade trade = JSONObject.parseObject(reqString, Trade.class);

        // 获取spring上下文
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        // 获取TradeServerStrategy的所有实现类
        Map<String, TradeServerStrategy> result = applicationContext.getBeansOfType(TradeServerStrategy.class);
        // 根据交易码，获取具体的实现类
        TradeServerStrategy tradeServerStrategy = result.get(trade.getTradeCode());
        Assert.notNull(tradeServerStrategy, "根据交易码"+trade.getTradeCode()+"，未找到具体实现类。请检查交易码是否正确");

        // 执行交易的业务代码，获取返回报文
        String tradeResult = tradeServerStrategy.dealTrade(trade);
        // 将String转化为ByteBuf对象，并返回结果报文
        ctx.writeAndFlush(Unpooled.copiedBuffer(tradeResult, CharsetUtil.UTF_8));
        ctx.close();
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