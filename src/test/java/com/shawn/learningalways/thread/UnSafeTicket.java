package com.shawn.learningalways.thread;

/**
 * @ClassName: UnSafeTicket
 * @Description 线程不安全的ticket类
 * @author: Shawn Wu
 * @date: 2018/12/12 14:38
 * @version:
 */
public class UnSafeTicket implements Runnable{

    /*
     * 总票数为10
     * 之后在测试时会new一个unSafeTicket类，所以存在一个ticketCount值，被多个线程共享
     */
    int ticketCount = 10;

    @Override
    public void run() {
        /*
         * 模拟售票
         */
        while(true){
            // 如果票数大于0，则继续售票
            if(ticketCount > 0){
                try {
                    // 为了让线程安全问题明显些，加入线程休眠
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Thread.currentThread()是线程获取当前线程对象的方法，getName()获取调用者的线程名
                System.out.println(Thread.currentThread().getName() + "正在售票，剩余票数：" + ticketCount--);
            }
        }
    }
}