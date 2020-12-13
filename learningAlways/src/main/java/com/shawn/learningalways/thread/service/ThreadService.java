package com.shawn.learningalways.thread.service;

/**
 * ThreadService
 * 线程测试服务层
 *
 * @author Shawn Wu
 * @date 2020/12/13 20:08
 * @since v1
 */
public interface ThreadService {

    /**
     * countDownLatch测试
     * @param threadNum 线程数
     */
    void countDownLatchTest(int threadNum);
}
