package com.shawn.learningalways.thread.lock.leftrightdeadlock;

/**
 * @ClassName: Lock
 * @Description 锁对象
 * @author: Shawn Wu
 * @date: 2018/12/12 15:46
 * @version:
 */
public class Lock {
    /**
     * 私有构造方法，不让外部创建锁
     */
    private Lock(){};

    /**
     * A锁
     */
    public static final Object lockA = new Object();
    /**
     * B锁
     */
    public static final Object lockB = new Object();
}