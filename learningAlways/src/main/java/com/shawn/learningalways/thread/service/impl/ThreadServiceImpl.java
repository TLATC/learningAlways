package com.shawn.learningalways.thread.service.impl;

import com.shawn.learningalways.thread.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.*;

/**
 * ThreadServiceImpl
 * 线程测试服务层实现
 *
 * @author Shawn Wu
 * @date 2020/12/13 20:08
 * @since v1
 */
@Service
public class ThreadServiceImpl implements ThreadService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadServiceImpl.class);


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
     *
     * @param threadNum 线程数
     * @date 2020/12/13 21:35
     * @author Shawn Wu
     */
    @Override
    public void countDownLatchTest(int threadNum) {
        // 创建一个指定线程数的线程池
        String threadNamePrefix = "count-thread-";
        final ExecutorService fixedThreadPool = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new CustomizableThreadFactory(threadNamePrefix));

        // 创建CountDownLatch 对象， 设定需要计数的子线程数目
        final CountDownLatch latch = new CountDownLatch(threadNum);

        // 启多线程处理任务。这里子线程一定要不小于threadNum，才能回到主线程
        for(int i=0; i<threadNum; i++){
            final Runnable task = () -> {
                LOGGER.info("子线程{}处理任务中。。。", Thread.currentThread().getName());
                Random r = new Random();
                int number = r.nextInt(10);
                doSomeThing(number*100);

                // 计数-1
                latch.countDown();
            };
            fixedThreadPool.execute(task);
        }

        // 主线程等待所有任务执行完成
        try {
            latch.await();
            LOGGER.info("子线程任务处理完成，主线程{}继续", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
        // 关闭线程池
        fixedThreadPool.shutdown();
    }
}