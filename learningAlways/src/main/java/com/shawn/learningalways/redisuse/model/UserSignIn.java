package com.shawn.learningalways.redisuse.model;

import java.util.Date;

/**
 * UserSignIn
 * 用户签到类
 *
 * @author Shawn Wu
 * @date 2020/9/25 11:58
 * @since v1
 */
public class UserSignIn {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 最后签入时间（格式yyyy-mm-dd hh24:mm:ss）
     */
    private Date lastSignTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLastSignTime() {
        return lastSignTime;
    }

    public void setLastSignTime(Date lastSignTime) {
        this.lastSignTime = lastSignTime;
    }
}