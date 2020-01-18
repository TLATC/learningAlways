package com.shawn.learningalways.socket.model;

/**
 * @ClassName: Trade
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/16 10:56
 * @version:
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