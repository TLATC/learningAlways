package com.shawn.learningalways.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 系统名称: learningAlways
 * 模块名称: 测试模块
 * 类 名 称: AsyncTasks
 * 软件版权: Jones
 * 功能说明：异步任务类
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/14 16:18
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Component
public class AsyncTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTasks.class);

    public static Random random = new Random();

    /**
     * 无异步回调的任务
     */
    @Async
    public void doTaskOne(){
        LOGGER.debug("开始做任务一");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("任务一完成，耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 有异步回调的任务
     * @return
     */
    @Async
    public Future<String> doTaskTwo(){
        LOGGER.debug("开始做任务二");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("任务二完成，耗时：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    /**
     * 有异步回调的任务
     * @return
     */
    @Async
    public Future<String> doTaskThree(){
        LOGGER.debug("开始做任务三");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("任务三完成，耗时：" + (endTime - startTime) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }

    /**
     * 用线程池执行异步任务一
     */
    @Async("taskExecutor")
    public void doTaskExecutorOne(){
        LOGGER.debug("开始用线程池做任务一");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("线程池任务一完成，耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 用线程池执行异步任务二
     */
    @Async("taskExecutor")
    public void doTaskExecutorTwo(){
        LOGGER.debug("开始用线程池做任务二");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("线程池任务二完成，耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 用线程池执行异步任务三
     */
    @Async("taskExecutor")
    public void doTaskExecutorThree(){
        LOGGER.debug("开始用线程池做任务三");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        LOGGER.debug("线程池任务三完成，耗时：" + (endTime - startTime) + "毫秒");
    }
}
