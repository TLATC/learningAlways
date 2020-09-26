package com.shawn.learningalways.redisuse.model;

/**
 * SignInVO
 * 签到功能交互类
 *
 * @author Shawn Wu
 * @date 2020/9/25 13:54
 * @since v1
 */
public class SignInVO {

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SignInVO{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}