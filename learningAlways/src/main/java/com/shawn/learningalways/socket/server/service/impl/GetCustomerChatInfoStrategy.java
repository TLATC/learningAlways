package com.shawn.learningalways.socket.server.service.impl;

import com.shawn.learningalways.socket.model.Trade;
import com.shawn.learningalways.socket.server.service.TradeServerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: GetCustomerChatInfoStrategy
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/16 11:03
 * @version:
 */
@Component("10002")
public class GetCustomerChatInfoStrategy implements TradeServerStrategy {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GetCustomerChatInfoStrategy.class);

    /**
     * @Description 交易业务处理
     * @param trade 交易请求报文
     * @return
     * @date 2020/1/16 11:04
     * @auther Shawn Wu
     */
    @Override
    public void dealTrade(Trade trade) {
        LOGGER.debug("到达了交易10002");
    }
}