package com.shawn.learningalways.base.util;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.shawn.learningalways.base.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolManager
 * @Description 线程池管理类
 *              用单例模式防止new多个线程池
 * @author: Shawn Wu
 * @date: 2020/3/6 17:03
 * @version:
 */
public class ThreadPoolManager<T> {

    /**
     * 根据cpu的数量动态的配置核心线程数和最大线程数
     */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    /**
     * 核心线程数 = CPU核心数 + 1
     */
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    /**
     * 线程池最大线程数 = CPU核心数 * 2 + 1
     */
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    /**
     * 非核心线程闲置时超时1s
     */
    private static final int KEEP_ALIVE = 1;
    /**
     * 保存已创建过的线程池，key为线程池名 todo:改用redis，线程工具类还需要学习
     */
    private Map<String, Executor> executorMap = new HashMap<>();

    /**
     * 要确保该类只有一个实例对象，避免产生过多对象消费资源，所以采用单例模式
     */
    private ThreadPoolManager() {
    }

    private static ThreadPoolManager sInstance;

    public synchronized static ThreadPoolManager getsInstance() {
        if (sInstance == null) {
            sInstance = new ThreadPoolManager();
        }
        return sInstance;
    }


    /**
     * @Description 开启一个无返回结果的线程
     * @param r 线程类
     * @param threadPoolName 线程池名
     * @return 
     * @date 2020/3/6 17:11
     * @author Shawn Wu
     */
    public void execute(Runnable r, String threadPoolName) {
        if(StringUtils.isEmpty(threadPoolName)){
            throw new CommonException("线程池名字不能为空");
        }

        // 从map中，根据线程池名取值
        Executor executor = executorMap.get(threadPoolName);

        // 如果没创建过，则创建
        if(executor == null){
            /**
             * corePoolSize:核心线程数
             * maximumPoolSize：线程池所容纳最大线程数(workQueue队列满了之后才开启)
             * keepAliveTime：非核心线程闲置时间超时时长
             * unit：keepAliveTime的单位
             * workQueue：等待队列，存储还未执行的任务。
             *            注意，这个是为啥不能用默认的fixedThreadPool之类的原因，
             *            不指定大小可能会OOM ！
             * threadFactory：线程创建的工厂
             * handler：异常处理机制
             *
             */
            executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                    KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                    new CustomizableThreadFactory(threadPoolName));
            executorMap.put(threadPoolName, executor);
            // 把一个任务丢到了线程池中
            executor.execute(r);
            return;
        }

        // 若创建过，则判断对应的是否为ThreadPoolExecutor
        if(!(executor instanceof ThreadPoolExecutor)){
            throw new CommonException("线程池类型错误，应该为ThreadPoolExecutor");
        }
        ThreadPoolExecutor tpExecutor = (ThreadPoolExecutor)executor;
        // 把一个任务丢到了线程池中
        tpExecutor.execute(r);
    }

    /**
     * @Description 开启一个有返回结果的线程
     * @param r 线程类
     * @param threadPoolName 线程池名
     * @return 
     * @date 2020/3/6 17:30
     * @author Shawn Wu
     */
    public Future<T> submit(Callable<T> r, String threadPoolName) {
        if(StringUtils.isEmpty(threadPoolName)){
            throw new CommonException("线程池名字不能为空");
        }

        Executor executor = executorMap.get(threadPoolName);
        if (executor == null) {
            executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                    KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                    new CustomizableThreadFactory(threadPoolName));
            executorMap.put(threadPoolName, executor);
        }

        // 若线程池名对应的不是ThreadPoolExecutor，则给予提示
        if(!(executor instanceof ThreadPoolExecutor)){
            throw new CommonException("线程池类型错误，应该为ThreadPoolExecutor");
        }

        ThreadPoolExecutor tpExecutor = (ThreadPoolExecutor)executor;
        return tpExecutor.submit(r);
    }

    public void ttlExecute(Runnable r, String threadPoolName) {
        if(StringUtils.isEmpty(threadPoolName)){
            throw new CommonException("线程池名字不能为空");
        }

        Executor executor = executorMap.get(threadPoolName);
        if (executor == null) {
            executor = TtlExecutors.getTtlExecutorService(new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                    KEEP_ALIVE, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20),
                    new CustomizableThreadFactory(threadPoolName)));
            executorMap.put(threadPoolName, executor);
        }
        // 把一个任务丢到了线程池中
        executor.execute(r);
    }

    /**
     * 把任务移除等待队列
     * @param r
     */
    public void cancel(Runnable r, String threadPoolName) {
        if(StringUtils.isEmpty(threadPoolName)){
            throw new CommonException("线程池名字不能为空");
        }

        Executor executor = executorMap.get(threadPoolName);
        if (r != null) {
//            executor.getQueue().remove(r);
        }
    }

    /**
     * @Description 关闭指定的线程池
     * @param threadPoolName 线程池名
     * @return
     * @date 2020/3/7 15:34
     * @author Shawn Wu
     */
    public void shutDown(String threadPoolName){
        if(StringUtils.isEmpty(threadPoolName)){
            throw new CommonException("线程池名字不能为空");
        }

        Executor executor = executorMap.get(threadPoolName);
//        executor.shutdown();
        executorMap.remove(threadPoolName);
    }

}