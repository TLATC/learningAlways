package com.shawn.learningalways.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.netty.model.Trade;
import com.shawn.learningalways.netty.service.TradeServerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GetCustomerChatInfoStrategy
 * 获取客户聊天信息的交易类（具体交易实现示例2）
 *
 * @author Shawn Wu
 * @date 2020/9/14 18:28
 * @since v1
 */
@Component("20002")
public class GetCustomerChatInfoStrategy implements TradeServerStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetCustomerChatInfoStrategy.class);

    /**
     * 交易业务处理
     *
     * @param trade 交易请求报文
     * @date 2020/1/16 11:04
     * @author Shawn Wu
     */
    @Override
    public String dealTrade(Trade trade) {
        LOGGER.debug("此处是netty服务端，到达了交易20002");
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "交易20002处理完毕，这里是返回");
        return result.toJSONString();
    }
}