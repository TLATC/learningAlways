package com.shawn.learningalways.redisuse.service.impl;

import com.shawn.learningalways.base.constant.CacheConstant;
import com.shawn.learningalways.redisuse.model.UserRank;
import com.shawn.learningalways.redisuse.service.UserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: UserRankServiceImpl
 * @Description 用户排行榜服务层实现
 * @author: Shawn Wu
 * @date: 2019/11/26 15:30
 * @version:
 */
@Service
public class UserRankServiceImpl implements UserRankService{

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * redis中用户排序的key值
     */
    private String userRankKey = CacheConstant.USER_SCORE_RANK;


    /**
     * @Description 用户分数增加1
     * @param userId 用户id
     * @return
     * @date 2019/11/26 15:31
     * @auther Shawn Wu
     */
    @Override
    public void incrUserScore(String userId) {
        // 如果排名为空，则说明是新用户，将其分数默认为0
        if(null == redisTemplate.opsForZSet().rank(userRankKey, userId)){
            redisTemplate.opsForZSet().add(userRankKey, userId, 0);
        }
        redisTemplate.opsForZSet().incrementScore(userRankKey, userId, 1);
    }


    /**
     * @Description 获取用户排行榜
     * @param
     * @return
     * @date 2019/11/26 15:31
     * @auther Shawn Wu
     */
    @Override
    public Set<UserRank> getUserRankList() {
        if(redisTemplate.hasKey(userRankKey)){
            // 0,-1的参数代表查询改key下所有的value
            return (Set<UserRank>)redisTemplate.opsForZSet().reverseRange(userRankKey, 0, -1);
        }
        return new HashSet<>();
    }
}