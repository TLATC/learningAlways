package com.shawn.learningalways.thread;

/**
 * @ClassName: ThreadTestDemo
 * @Description 线程测试类
 * @author: Shawn Wu
 * @date: 2018/12/12 14:48
 * @version:
 */
public class ThreadTestDemo {

    /**
     * 由于没加锁，多线程同步运行时，可能会出现剩余票数为负数的情况
     */
    private static void UnSafeTicketTest(){
        // 创建UnSafeTicket的Runnable对象
        UnSafeTicket unSafeTicket = new UnSafeTicket();

        // 创建线程对象的模拟三个售票窗口
        new Thread(unSafeTicket, "窗口1").start();
        new Thread(unSafeTicket, "窗口2").start();
        new Thread(unSafeTicket, "窗口3").start();
    }

    /**
     * 加入了同步锁，不会出现剩余票数为负数的情况
     */
    private static void synchronizedTicketTest(){
        // 创建synchronizedTicketTest的Runnable对象
        SynchronizedTicket synchronizedTicket = new SynchronizedTicket();

        // 创建线程对象的模拟三个售票窗口
        new Thread(synchronizedTicket, "窗口1").start();
        new Thread(synchronizedTicket, "窗口2").start();
        new Thread(synchronizedTicket, "窗口3").start();
    }

    public static void main(String[] args) {
        /// 测试非线程安全买票
//        UnSafeTicketTest();
        // 测试加入同步锁后，进行卖票
        synchronizedTicketTest();
    }
}