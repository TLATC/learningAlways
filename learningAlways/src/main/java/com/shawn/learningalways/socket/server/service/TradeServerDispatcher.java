package com.shawn.learningalways.socket.server.service;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.util.SpringUtils;
import com.shawn.learningalways.socket.model.Trade;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @ClassName: TradeServerDispatcher
 * @Description 交易服务端转发层
 * @author: Shawn Wu
 * @date: 2020/1/16 11:06
 * @version:
 */
public class TradeServerDispatcher implements Runnable{

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeServerDispatcher.class);

    /**
     * 消息内容
     */
    private String socketMsg;

    public String getSocketMsg() {
        return socketMsg;
    }

    public void setSocketMsg(String socketMsg) {
        this.socketMsg = socketMsg;
    }

    /**
     * 线程执行内容
     */
    @Override
    public void run() {
        dispatcherTradeTrade(socketMsg);
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
    }
}