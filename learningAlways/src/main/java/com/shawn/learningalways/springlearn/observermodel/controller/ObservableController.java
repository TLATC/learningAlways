package com.shawn.learningalways.springlearn.observermodel.controller;

import com.alibaba.fastjson.JSONObject;
import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.springlearn.observermodel.model.TestObserverEvent;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ObservableController
 * 被观察者
 *
 * @author Shawn Wu
 * @date 2020/9/9 17:25
 * @since x
 */
@RestController
@RequestMapping(value = "/observer")
public class ObservableController extends BaseRender implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 测试触发TestObserverEvent事件，并传递消息
     *
     * @return result
     * @date 2020/9/9 17:47
     * @author Shawn Wu
     */
    @PostMapping("/testSendMsg")
    public JsonResult testSendMsg(@RequestBody JSONObject reqObj){
        String reqMsg = reqObj.getString("message");
        String message = StringUtils.isEmpty(reqMsg)? "测试在事件里传递的消息": reqMsg;

        TestObserverEvent testObserverEvent = new TestObserverEvent("");
        testObserverEvent.setMessage(message);
        this.applicationContext.publishEvent(testObserverEvent);

        return renderSuccess();
    }

}