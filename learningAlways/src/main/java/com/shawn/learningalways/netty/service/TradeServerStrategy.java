package com.shawn.learningalways.netty.service;

import com.shawn.learningalways.netty.model.Trade;

/**
 * TradeServerStrategy
 * 交易接口（使用策略模式）
 * 实现类中使用@Component，里面写交易码
 *
 * @author Shawn Wu
 * @date 2020/9/14 18:28
 * @since v1
 */
public interface TradeServerStrategy {

    /**
     * 处理具体的交易业务逻辑
     *
     * @param trade 接收到交易报文
     * @return 交易结果报文
     * @date 2020/9/14 18:30
     * @author Shawn Wu
     *
     */
    String dealTrade(Trade trade);
}
