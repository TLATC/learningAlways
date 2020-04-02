package com.shawn.learningalways.thread;

import org.apache.commons.lang.StringUtils;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * CallableDemo
 * callable的示例类
 *
 * @author Shawn Wu
 * @date 2020/4/2 17:56
 * @since xxx
 */
public class CallableDemo {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CallableDemo.class);

    /**
     * CallableThread
     * 成员内部类：一个有返回值的线程类
     *
     * @author Shawn Wu
     * @date 2020/4/2 17:56
     * @since xxx
     */
    static class CallableThread implements Callable<String>{

        @Override
        public String call() throws Exception {
            // 假设这里有一个耗时的操作
            Thread.sleep(6000);
            return null;
        }
    }


    /**
     * 测试：控制方法返回时间，超时则直接返回
     *
     * @date 2020/4/2 18:10
     * @author Shawn Wu
     */
    public static String fun(){
        // 记录开始时间
        long beginTime = System.currentTimeMillis();

        Callable<String> callableThread = new CallableThread();
        FutureTask<String> task = new FutureTask<>(callableThread);
        // 开启线程
        Thread thread = new Thread(task);
        thread.start();
        String result = "";

        // 限制超时返回的时限
        long limitTime = 3;
        try {
            // 如果超过限制的时间，就抛出异常
            result = task.get(limitTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            LOGGER.info("方法到达了超时限制，限时{}秒", limitTime);
        }

        // 记录结束时间
        long endTime = System.currentTimeMillis();
        LOGGER.debug("方法总计时长为: {} 秒", (endTime - beginTime) / 1000);

        return StringUtils.isEmpty(result)?"":result;
    }


    public static void main(String[] args) {
        fun();
    }
}