package com.shawn.learningalways.base.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


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
     * @Description 容器启动完成后执行
     *              已经可以调用service层方法
     * @param applicationArguments
     * @return
     * @date 2019/3/28 13:12
     * @auther Shawn Wu
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("容器加载已完成======");
    }
}