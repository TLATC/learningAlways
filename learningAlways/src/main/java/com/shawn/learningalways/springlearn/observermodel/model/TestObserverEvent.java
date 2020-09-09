package com.shawn.learningalways.springlearn.observermodel.model;

import org.springframework.context.ApplicationEvent;

/**
 * TestObserverEvent
 * 测试观察者模式用的事件类
 *
 * @author Shawn Wu
 * @date 2020/9/9 17:29
 * @since x
 */
public class TestObserverEvent extends ApplicationEvent {

    /**
     * 消息
     */
    private String message;

    public TestObserverEvent(Object source) {
        super(source);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}