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

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
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
     * 阿里巴巴threadLocal增强类，可以子啊异步方法中获取socket消息
     */
    private static final ThreadLocal<Socket> localSocket = new TransmittableThreadLocal<>();

    /**
     * socket赋值
     * @param socket socket
     */
    public void setSocket(Socket socket){
        localSocket.set(socket);
    }

    /**
     * 删除本地线程
     */
    public void removeSocket(){
        localSocket.remove();
    }

    /**
     * 线程执行内容
     */
    @Override
    public void run() {
        dispatcherTradeTrade(localSocket.get());
    }


    /**
     * @Description 获取socket报文中的正文内容
     * @param is socket输入流
     * @return 正文内容
     * @date 2020/1/17 21:14
     * @auther Shawn Wu
     */
    private String getSocketXmlContent(InputStream is){
        // 固定前8位是报文体长度
        byte[] buffer = new byte[8];
        int len = 0;
        try {
            is.read(buffer);
            int contentLength = Integer.parseInt(new String(buffer, 0, 8));
            LOGGER.debug("收到的报文长度为：{}", contentLength);

            // 获取报文内容
            buffer = new byte[contentLength];
            len = -1;
            len = is.read(buffer);
            // -1说明没有输入输出内容，是客户端的连接或断开
            if(len < 0){
                return "";
            }
        } catch (IOException e) {
            LOGGER.error("从socket中读取报文内容异常", e);
        }
        return new String(buffer, 0, len);
    }

    /**
     * @Description 接收交易报文，并转发给具体的交易
     * @param socket 交易报文
     * @return
     * @date 2020/1/16 15:57
     * @auther Shawn Wu
     */
    public synchronized void dispatcherTradeTrade(Socket socket){
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            LOGGER.error("从socket中读取输入流异常", e);
        }
        // 获取到的报文消息
        String xmlContent = getSocketXmlContent(inputStream);
        LOGGER.debug("从socket收到的报文内容是：{}", xmlContent);
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
        removeSocket();
    }
}