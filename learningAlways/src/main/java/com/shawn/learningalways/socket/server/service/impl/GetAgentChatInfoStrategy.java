package com.shawn.learningalways.socket.server.service.impl;

import com.shawn.learningalways.socket.model.Trade;
import com.shawn.learningalways.socket.server.service.TradeServerStrategy;
import org.springframework.stereotype.Component;

/**
 * @ClassName: GetAgentChatInfoStrategy
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/16 10:55
 * @version:
 */
@Component("10001")
public class GetAgentChatInfoStrategy implements TradeServerStrategy {


    /**
     * @Description 交易业务处理
     * @param trade 交易请求报文
     * @return
     * @date 2020/1/16 11:03
     * @auther Shawn Wu
     */
    @Override
    public void dealTrade(Trade trade) {
        System.out.println("到达了交易10001");
    }
}