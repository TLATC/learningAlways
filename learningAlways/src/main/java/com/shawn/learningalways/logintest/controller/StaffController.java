package com.shawn.learningalways.logintest.controller;

import com.shawn.learningalways.base.controller.BaseRender;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.login.LoginContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: StaffController
 * @Description 职员控制层
 * @author: Shawn Wu
 * @date: 2019/12/14 18:21
 * @version:
 */
@RestController
@RequestMapping(value = "/staff")
public class StaffController extends BaseRender {

    @PostMapping("/doSomeThing")
    public JsonResult doSomeThing(){
        System.out.println("hhh");
        System.out.println("获取登录人姓名为：" + LoginContextHolder.getLoginContext().getStaff().getName());
        System.out.println("啦啦啦");
        return renderSuccess();
    }
}