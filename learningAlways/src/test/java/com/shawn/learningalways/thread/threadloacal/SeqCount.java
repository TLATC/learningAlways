package com.shawn.learningalways.thread.threadloacal;

/**
 * @ClassName: SeqCount
 * @Description 本地线程测试计数
 * @author: Shawn Wu
 * @date: 2019/11/25 21:45
 * @version:
 */
public class SeqCount {

    /**
     * @Description 本地线程计数值
     * @param
     * @return 
     * @date 2019/11/25 21:49
     * @auther Shawn Wu
     */
    private static ThreadLocal<Integer> seqCount = new ThreadLocal<Integer>(){
        // 重写初始化方法
        @Override
        protected Integer initialValue(){
            return 0;
        }
    };

    /**
     * @Description 计数值加1
     * @param
     * @return
     * @date 2019/11/25 21:50
     * @auther Shawn Wu
     */
    public int nextSeq(){
        seqCount.set(seqCount.get() + 1);
        return seqCount.get();
    }

    /**
     * @Description 定义一个线程类
     * @param
     * @return 
     * @date 2019/11/25 21:58
     * @auther Shawn Wu
     */
    public static class SeqThread extends Thread {

        private SeqCount seqCount;

        public SeqThread(SeqCount seqCount){
            this.seqCount = seqCount;
        }

        // 本线程计数值递增三次
        @Override
        public void run() {
            for(int i=0; i<3; i++){
                System.out.println(Thread.currentThread().getName() + " seqCount:" + seqCount.nextSeq());
            }
        }
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();

        SeqThread seqThread1 = new SeqThread(seqCount);
        SeqThread seqThread2 = new SeqThread(seqCount);
        SeqThread seqThread3 = new SeqThread(seqCount);
        SeqThread seqThread4 = new SeqThread(seqCount);

        seqThread1.start();
        seqThread2.start();
        seqThread3.start();
        seqThread4.start();
    }

}