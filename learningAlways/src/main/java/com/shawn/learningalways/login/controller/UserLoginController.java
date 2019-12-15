package com.shawn.learningalways.login.controller;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.exception.CommonException;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.login.model.LoginContext;
import com.shawn.learningalways.login.model.Staff;
import com.shawn.learningalways.login.service.impl.RedisTicketRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName: UserLoginController
 * @Description
 * @author: Shawn Wu
 * @date: 2019/12/14 18:11
 * @version:
 */
@RestController
@RequestMapping(value = "/userLogin")
public class UserLoginController extends BaseController{

    @Autowired
    RedisTicketRepository redisTicketRepository;


    /**
     * @Description 职员登录
     * @param staff
     * @return
     * @date 2019/12/14 18:16
     * @auther Shawn Wu
     */
    @PostMapping(value = "/staff")
    public JsonResult staffLogin(@RequestBody Staff staff){
        /*
         * 此处应该校验登录人信息，略
         */
        if(StringUtils.isEmpty(staff.getName())){
            throw new CommonException("职工姓名不能为空");
        }

        /*
         * 将当前登录人信息放入远程仓库中
         */
        LoginContext loginContext = new LoginContext();
        loginContext.setStaff(staff);
        String ticket = redisTicketRepository.storage(loginContext);
        System.out.println("职员登录了。。。。");
        return renderSuccess(ticket);
    }
}