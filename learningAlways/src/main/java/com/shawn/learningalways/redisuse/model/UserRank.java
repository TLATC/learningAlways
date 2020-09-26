package com.shawn.learningalways.redisuse.model;

import java.io.Serializable;

/**
 * @ClassName: UserRank
 * @Description 用户排名
 * @author: Shawn Wu
 * @date: 2019/11/26 15:12
 * @version:
 */
public class UserRank implements Serializable {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户分数
     */
    private Double userScore;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getUserScore() {
        return userScore;
    }

    public void setUserScore(Double userScore) {
        this.userScore = userScore;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}