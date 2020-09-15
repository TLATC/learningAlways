package com.shawn.learningalways.netty;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.conf.model.NettyYmlProperties;
import com.shawn.learningalways.base.util.SpringUtils;
import com.shawn.learningalways.netty.model.Trade;
import com.shawn.learningalways.netty.service.TradeServerStrategy;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import reactor.core.support.Assert;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * TradeServerHandler
 * netty交易服务事件处理类
 *
 * @author Shawn Wu
 * @date 2020/9/10 13:40
 * @since x
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
        ByteBuf buffer = (ByteBuf) msg;
        String reqString = buffer.toString(Charset.forName(nettyYmlProperties.getEncoding()));
        LOGGER.debug("收到了来自客户端的消息，内容为： {}", reqString);

        // 固定报文前8位标识长度
        reqString = reqString.substring(8, reqString.length());
        JSONObject reqObj = JSONObject.parseObject(reqString);
        // 交易码
        String tradeCode = reqObj.getString("tradeCode");
        // 交易流水号
        String tradeSeqNo = reqObj.getString("tradeSeqNo");

        // 获取spring上下文
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        // 获取TradeServerStrategy的所有实现类
        Map<String, TradeServerStrategy> result = applicationContext.getBeansOfType(TradeServerStrategy.class);
        // 根据交易码，获取具体的实现类
        TradeServerStrategy tradeServerStrategy = result.get(tradeCode);
        Assert.notNull(tradeServerStrategy, "根据交易码"+tradeCode+"，未找到具体实现类。请检查交易码是否正确");
        // 执行交易的业务代码
        Trade trade = new Trade();
        trade.setTradeCode(tradeCode);
        trade.setTradeSeqNo(tradeSeqNo);
        tradeServerStrategy.dealTrade(trade);
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