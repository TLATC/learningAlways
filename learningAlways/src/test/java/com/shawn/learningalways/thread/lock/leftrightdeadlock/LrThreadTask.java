package com.shawn.learningalways.thread.lock.leftrightdeadlock;

import com.shawn.learningalways.base.exception.CommonException;

import java.util.Random;

/**
 * @ClassName: LrThreadTask
 * @Description 线程任务类（锁顺序死锁）
 * @author: Shawn Wu
 * @date: 2018/12/12 15:51
 * @version:
 */
public class LrThreadTask implements Runnable{

    /**
     * 此线程任务可能会出现锁顺序死锁 ！！
     * 即A拿到了A锁，想去拿B锁；
     * 同时，B拿到了B锁，想去拿A锁；
     * A、B互相等待，导致死锁
     */
    @Override
    public void run() {

        // 用随机数，来模拟CPU随机分配执行权的行为
        int x = new Random().nextInt(10);
        System.out.println("x的值是：" + x);

        while(true){
            threadSleep(2000);
            if(x%2 == 0){
                // 情况一，先执行A再执行B：即A同学先拿了A门的钥匙去开A门，然后打算开B门
                synchronized (Lock.lockA){
                    System.out.println("A同学---打开了A门");
                    // 需要加入休眠，不然不容易出现死锁
                    threadSleep(2000);
                    synchronized (Lock.lockB){
                        System.out.println("A同学---打开了B门");
                    }
                }
            }else{
                // 情况二，先执行B执行A：B同学先拿了B门的钥匙，去开B门，然后打算开A门
                synchronized (Lock.lockB){
                    System.out.println("B同学---打开了B门");
                    threadSleep(2000);
                    synchronized (Lock.lockA){
                        System.out.println("B同学---打开了A门");
                    }
                }
            }
            x++;
        }
    }

    /**
     * 线程休眠
     * @param sleepTime 休眠时间
     */
    private void threadSleep(int sleepTime){
        if(sleepTime < 0){
            throw new CommonException("参数不符合要求");
        }
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}