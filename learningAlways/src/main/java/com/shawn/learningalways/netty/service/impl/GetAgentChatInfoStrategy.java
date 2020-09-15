package com.shawn.learningalways.netty.service.impl;


import com.shawn.learningalways.netty.service.TradeServerStrategy;
import com.shawn.learningalways.netty.model.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GetAgentChatInfoStrategy
 * 获取坐席聊天信息的交易类（具体交易实现示例1）
 *
 * @author Shawn Wu
 * @date 2020/9/14 18:28
 * @since v1
 */
@Component("20001")
public class GetAgentChatInfoStrategy implements TradeServerStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetAgentChatInfoStrategy.class);

    /**
     * 交易业务处理
     *
     * @param trade 交易请求报文
     * @date 2020/1/16 11:03
     * @author Shawn Wu
     */
    @Override
    public void dealTrade(Trade trade) {
        LOGGER.debug("此处是netty服务端，到达了交易20001");
    }
}