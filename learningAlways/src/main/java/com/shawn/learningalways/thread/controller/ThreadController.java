package com.shawn.learningalways.thread.controller;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.thread.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ThreadController
 * 线程测试学习
 *
 * @author Shawn Wu
 * @date 2020/12/13 20:05
 * @since v1
 */
@RestController
@RequestMapping("/thread")
public class ThreadController extends BaseRender{
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadController.class);

    /**
     * 线程服务层
     */
    private final ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }


    /**
     * 模拟业务耗时
     *
     * @param time 耗时，单位毫秒
     * @date 2020/12/13 20:17
     * @author Shawn Wu
     */
    private void doSomeThing(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * countDownLatch测试
     * todo: 使用countDownLatch与否时，测试事务，子线程更改的数据库是否被主线程拿到
     *
     * @param requestObj num 线程数
     * @return result
     * @date 2020/12/13 21:59
     * @author Shawn Wu
     */
    @PostMapping("/countDownLatchTest")
    public JsonResult countDownLatchTest(@RequestBody JSONObject requestObj){
        long startTime =  System.currentTimeMillis();
        int num = requestObj.getInteger("num");
        num = num==0?10:num;

        doSomeThing(200);
        LOGGER.debug("进入线程任务前，距起始点耗时{}毫秒", System.currentTimeMillis()-startTime);

        threadService.countDownLatchTest(num);
        LOGGER.debug("发起线程任务后，距起始点耗时{}毫秒", System.currentTimeMillis()-startTime);

        doSomeThing(500);
        LOGGER.debug("继续模拟业务逻辑，距起始点耗时{}毫秒", System.currentTimeMillis()-startTime);
        return renderSuccess();
    }
}