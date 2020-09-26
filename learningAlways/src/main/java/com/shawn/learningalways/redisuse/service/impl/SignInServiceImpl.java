package com.shawn.learningalways.redisuse.service.impl;

import com.shawn.learningalways.base.constant.CacheConstant;
import com.shawn.learningalways.base.constant.DateTimeConstant;
import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.base.util.DateTimeUtil;
import com.shawn.learningalways.base.util.RedisUtil;
import com.shawn.learningalways.redisuse.model.UserSignIn;
import com.shawn.learningalways.redisuse.service.SignInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.support.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * SignInServiceImpl
 * 签入实现类
 *
 * @author Shawn Wu
 * @date 2020/9/25 13:57
 * @since v1
 */
@Service
public class SignInServiceImpl implements SignInService{
    private static final Logger LOGGER = LoggerFactory.getLogger(SignInServiceImpl.class);

    private final RedisTemplate redisTemplate;
    private final RedisUtil redisUtil;

    @Autowired
    public SignInServiceImpl(RedisTemplate redisTemplate, RedisUtil redisUtil) {
        this.redisTemplate = redisTemplate;
        this.redisUtil = redisUtil;
    }


    /**
     * 获取指定日期签入时，redis中签入的key值
     *
     * @param offset 偏移量，这里就是userId
     * @param date 指定日期
     * @return 签入key值
     * @date 2020/9/25 15:01
     * @author Shawn Wu
     */
    private String getSignInKey(Long offset, String date){
        // todo：由于bitmap最多只能存2^32（40亿）的长度，所以这里将key按100w分段
//        long index = offset/limitLength;
        long index = 0;
        return CacheConstant.USER_SIGN_IN_PREFIX + date + ":" + index ;
    }

    /**
     * 判断用户在指定日期是否签到过
     *
     * @param userId 用户id
     * @param date 指定日期，格式yyyy-mm-hh
     * @return true：已签到，false：未签到
     * @date 2020/9/25 15:26
     * @author Shawn Wu
     */
    @Override
    public Boolean isSingIn(Long userId, String date) {
        Assert.notNull(userId, "用户id不能为空");
        Assert.notNull(date, "日期不能为空");
        Boolean isSignIn = redisTemplate.opsForValue().getBit(getSignInKey(userId, date), userId);
        return Optional.ofNullable(isSignIn).orElse(false);
    }

    /**
     * 用户签入
     *
     * @param userSignIn 用户签入类
     * @date 2020/9/25 15:37
     * @author Shawn Wu
     */
    @Override
    public void signIn(UserSignIn userSignIn) {
        Long userId = userSignIn.getUserId();
        Assert.notNull(userId, "用户id不能为空");

        // 不重复签入
        if(isSingIn(userId, DateTimeUtil.getNowDateEN())){
            return;
        }
        // 签入，记录保留1年
        String key = getSignInKey(userId, DateTimeUtil.getNowDateEN());
        redisTemplate.opsForValue().setBit(key, userId, true);
        redisTemplate.expire(key, 365, TimeUnit.DAYS);
        LOGGER.debug("用户id：{}签入成功", userId);
    }

    /**
     * 获取指定日期的活跃用户数量
     *
     * @param specifiedDay 指定日期（格式yyyy-mm-hh）
     * @return 活跃用户数量
     * @date 2020/9/26 17:23
     * @author Shawn Wu
     */
    @Override
    public long getActiveUserCountSpecified(String specifiedDay) {
        Assert.notNull(specifiedDay, "指定日期不能为空");
        return redisUtil.bitCount(getSignInKey(0L, specifiedDay));
    }

    /**
     * 获取指定时间段内的活跃用户数
     *
     * @param beginDay 开始日期（格式yyyy-mm-hh）
     * @param endDay 结束日期（格式yyyy-mm-hh）
     * @return 活跃用户数
     * @date 2020/9/25 18:23
     * @author Shawn Wu
     */
    @Override
    public long getActiveUserCount(String beginDay, String endDay) {
        Assert.notNull(beginDay, "开始日期不能为空");
        Assert.notNull(endDay, "结束日期不能为");
        int distance = DateTimeUtil.periodCount(endDay, beginDay, DateTimeConstant.DAY);
        if(distance < 0){
            throw new CommonException("结束日期必须晚于开始日期");
        }

        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(beginDay, yyyyMMdd);
        final long[] count = {0};
        /*
         * 遍历区间内的key，累加活跃用户数
         * todo: 此处用bitOp的and方法更好，会少建立连接。但没找到咋用。
         *       类似 bitOp('AND', 'stat', 'stat_2017-01-10', 'stat_2017-01-11', 'stat_2017-01-12')
         */
        Stream.iterate(startLocalDate, d -> d.plusDays(1)).limit(distance+1).forEach((localDate -> {
            String signKey = getSignInKey(0L, localDate.format(yyyyMMdd));
            long dayCount = redisUtil.bitCount(signKey);
            count[0] += dayCount;
        }));
        return count[0];
    }

}