package com.shawn.learningalways.socket.server.service;

import com.shawn.learningalways.socket.model.Trade;

/**
 * @ClassName: TradeServerStrategy
 * @Description 交易接口（使用策略模式）
 *              实现类中使用@Component，里面写交易码
 * @author: Shawn Wu
 * @date: 2020/1/16 10:49
 * @version:
 */
public interface TradeServerStrategy {

    /**
     * @Description 处理具体的交易业务逻辑
     * @param trade 接收到交易报文
     * @return 
     * @date 2020/1/16 10:52
     * @auther Shawn Wu
     */
    void dealTrade(Trade trade);
}
