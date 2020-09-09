package com.shawn.learningalways.springlearn.observermodel;

import com.shawn.learningalways.springlearn.observermodel.model.TestObserverEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * TestNotifier
 * 测试用的观察者，监听TestObserverEvent
 *
 * @author Shawn Wu
 * @date 2020/9/9 17:33
 * @since x
 */
@Component
public class TestNotifier implements ApplicationListener<TestObserverEvent>{
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestNotifier.class);


    /**
     * 当监听到TestObserverEvent事件时，会触发此事件
     *
     * @param testObserverEvent 测试观察者模式用的事件类
     * @date 2020/9/9 17:35
     * @author Shawn Wu
     */
    @Override
    public void onApplicationEvent(TestObserverEvent testObserverEvent) {
        LOGGER.debug("收到了TestObserverEvent事件，事件传递过来的消息是：{}", testObserverEvent.getMessage());
    }
}