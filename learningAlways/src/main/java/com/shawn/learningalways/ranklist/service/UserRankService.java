package com.shawn.learningalways.ranklist.service;

import com.shawn.learningalways.ranklist.model.UserRank;

import java.util.Set;

/**
 * @ClassName: UserRankService
 * @Description 用户排序服务层
 * @author: Shawn Wu
 * @date: 2019/11/26 15:20
 * @version:
 */
public interface UserRankService {

    /**
     * 用户分数加1
     * @param userId 用户id
     */
    void incrUserScore(String userId);

    /**
     * 获取用户排行榜
     * @return
     */
    Set<UserRank> getUserRankList();
}
