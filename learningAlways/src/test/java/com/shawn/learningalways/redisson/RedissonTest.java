package com.shawn.learningalways.redisson;

import com.shawn.learningalways.LearningAlwaysApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedissonTest
 * @Description
 * @author: Shawn Wu
 * @date: 2020/1/24 16:29
 * @version:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearningAlwaysApplication.class)
public class RedissonTest {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonTest.class);
    /**
     * redisson客户端
     */
    @Autowired
    private RedissonClient redissonClient;
    /**
     * web上下文
     */
    @Autowired
    private WebApplicationContext wac;
    /**
     * 模拟mvc请求
     */
    private MockMvc mockMvc;


    /**
     * @Description 初始化MockMvc
     * @param
     * @return
     * @date 2019/12/17 19:38
     * @auther Shawn Wu
     */
    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * @Description 获取redisson分布式锁的测试类
     * @param
     * @return
     * @date 2020/1/24 16:36
     * @auther Shawn Wu
     */
    @Test
    public void lockTest(){
        // 分布式锁名
        String key = "redissonTest";
        // 获取锁
        RLock lock = redissonClient.getLock(key);
        // 是否获取到锁的标志
        boolean lockedFlag = false;

        // 尝试获取分布式锁，失效时间10秒
        try {
            lockedFlag = lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("尝试获取redisson分布式锁异常", e);
        }

        if(!lockedFlag){
            // 获取锁失败
            LOGGER.debug("未获取到redisson分布式锁");
            return;
        }

        LOGGER.info("此处应当是业务逻辑。。");
    }
}