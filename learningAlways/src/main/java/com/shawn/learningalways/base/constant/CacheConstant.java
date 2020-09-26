package com.shawn.learningalways.base.constant;

/**
 * @ClassName: CacheConstant
 * @Description 缓存常量类
 * @author: Shawn Wu
 * @date: 2019/11/26 15:33
 * @version:
 */
public class CacheConstant {

    /**
     * 本工程redis的key统一前缀
     */
    public static final String KEY_PREFIX = "learningAlways:";

    /**
     * 用户排行榜的key值
     */
    public static final String USER_SCORE_RANK = KEY_PREFIX + "userScoreRank";
    /**
     * 用户签入的key前缀
     */
    public static final String USER_SIGN_IN_PREFIX = KEY_PREFIX + "userSignIn:";
}