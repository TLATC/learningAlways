package com.shawn.learningalways.base.runner;

import com.shawn.learningalways.socket.server.SocketServerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;


/**
 * @ClassName: MyApplicationRunner
 * @Description 执行时机为容器启动完成
 * @author: Shawn Wu
 * @date: 2019/3/28 13:06
 * @version:
 */
@Component
public class MyApplicationRunner  implements ApplicationRunner {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationRunner.class);


    /**
     * socket服务线程
     */
    private Thread socketThread;
    /**
     * socket服务线程
     */
    @Autowired
    private SocketServerThread socketServerThread;


    /**
     * @Description 容器启动完成后执行
     *              已经可以调用service层方法
     * @param applicationArguments
     * @return
     * @date 2019/3/28 13:12
     * @auther Shawn Wu
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.debug("容器加载已完成");

        // 另启线程开启socket，监听传来的报文
        socketThread = new Thread(socketServerThread);
        socketThread.start();
    }

    
    /**
     * @Description 应用摧毁前，关闭socket服务
     * @param
     * @return 
     * @date 2020/1/16 22:02
     * @auther Shawn Wu
     */
    @PreDestroy
    public void closeSocketThread(){
        // 经试验，目前只有stop能成功关闭socket子线程
        socketThread.stop();
    }


}