package com.shawn.learningalways.socket.server.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.shawn.learningalways.base.util.SpringUtils;
import com.shawn.learningalways.socket.model.Trade;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName: TradeServerDispather
 * @Description 交易服务端转发层
 * @author: Shawn Wu
 * @date: 2020/1/16 11:06
 * @version:
 */
@Component
public class TradeServerDispatcher implements Runnable{

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServerDispatcher.class);

    /**
     * 阿里巴巴threadLocal增强类，可以在异步方法中获取socket消息
     */
    private static final ThreadLocal<String> localSocketMsg = new TransmittableThreadLocal<>();

    /**
     * socket赋值
     * @param content socket客户端发来的消息内容
     */
    public void setSocketMsg(String content){
        localSocketMsg.set(content);
    }

    /**
     * 删除本地线程
     */
    public void removeSocketMsg(){
        localSocketMsg.remove();
    }

    /**
     * 获取本地线程
     * @return
     */
    public String getSocketMsg(){
        return localSocketMsg.get();
    }

    /**
     * 线程执行内容
     */
    @Override
    public void run() {
        dispatcherTradeTrade(getSocketMsg());
    }


    /**
     * @Description 接收交易报文，并转发给具体的交易
     * @param xmlContent 交易报文
     * @return
     * @date 2020/1/16 15:57
     * @auther Shawn Wu
     */
    public void dispatcherTradeTrade(String xmlContent){
        if(StringUtils.isEmpty(xmlContent)){
            return;
        }

        JSONObject reqObj = JSONObject.parseObject(xmlContent);
        // 交易码
        String tradeCode = reqObj.getString("tradeCode");
        // 交易流水号
        String tradeSeqNo = reqObj.getString("tradeSeqNo");
        LOGGER.debug("收到交易请求，交易码为：{}，流水号为：{}", xmlContent, tradeSeqNo);

        // 获取spring上下文
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        // 获取TradeServerStrategy的所有实现类
        Map<String, TradeServerStrategy> result = applicationContext.getBeansOfType(TradeServerStrategy.class);
        // 根据交易码，获取具体的实现类
        TradeServerStrategy tradeServerStrategy = result.get(tradeCode);
        // 执行交易的业务代码
        Trade trade = new Trade();
        trade.setTradeCode(tradeCode);
        trade.setTradeSeqNo(tradeSeqNo);
        tradeServerStrategy.dealTrade(trade);

        // 移除本地线程，防止内存溢出
        removeSocketMsg();
    }
}