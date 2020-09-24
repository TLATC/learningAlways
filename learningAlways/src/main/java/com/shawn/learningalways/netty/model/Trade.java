package com.shawn.learningalways.netty.model;

/**
 * Trade
 * 交易实体类
 * 与约定好的报文格式对应
 *
 * @author Shawn Wu
 * @date 2020/1/16 10:56
 * @since v1
 */
public class Trade {

    /**
     * 交易码
     */
    private String tradeCode;
    /**
     * 交易流水号
     */
    private String tradeSeqNo;
    /**
     * 交易内容
     */
    private String tradeContent;

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getTradeSeqNo() {
        return tradeSeqNo;
    }

    public void setTradeSeqNo(String tradeSeqNo) {
        this.tradeSeqNo = tradeSeqNo;
    }

    public String getTradeContent() {
        return tradeContent;
    }

    public void setTradeContent(String tradeContent) {
        this.tradeContent = tradeContent;
    }
}