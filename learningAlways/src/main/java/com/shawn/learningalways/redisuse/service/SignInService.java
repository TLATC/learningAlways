package com.shawn.learningalways.redisuse.service;

import com.shawn.learningalways.redisuse.model.UserSignIn;

/**
 * SignInService
 * 签到服务层
 *
 * @author Shawn Wu
 * @date 2020/9/25 13:06
 * @since v1
 */
public interface SignInService {

    /**
     * 判断用户在指定日期是否签到过
     *
     * @param userId 用户id
     * @param date 指定日期（格式yyyy-mm-hh）
     * @return true：已签到，false：未签到
     * @date 2020/9/25 15:25
     * @author Shawn Wu
     */
    Boolean isSingIn(Long userId, String date);

    /**
     * 用户签到
     *
     * @param userSignIn 用户签到类
     * @date 2020/9/25 13:07
     * @author Shawn Wu
     */
    void signIn(UserSignIn userSignIn);

    /**
     * 获取指定日期的活跃用户数量
     *
     * @param specifiedDay 指定日期（格式yyyy-mm-hh）
     * @return 活跃用户数量
     * @date 2020/9/26 17:23
     * @author Shawn Wu
     */
    long getActiveUserCountSpecified(String specifiedDay);

    /**
     * 获取指定时间段内的活跃用户数
     *
     * @param beginDay 开始日期（格式yyyy-mm-hh）
     * @param endDay 结束日期（格式yyyy-mm-hh）
     * @return 活跃用户数
     * @date 2020/9/25 18:16
     * @author Shawn Wu
     */
    long getActiveUserCount(String beginDay, String endDay);
}
