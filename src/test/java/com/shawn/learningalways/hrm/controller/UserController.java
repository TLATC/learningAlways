package com.shawn.learningalways.hrm.controller;

import com.shawn.learningalways.base.controller.BaseController;
import com.shawn.learningalways.base.model.JsonResult;
import com.shawn.learningalways.hrm.model.User;
import com.shawn.learningalways.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统名称: learningAlways
 * 模块名称: 用户管理
 * 类 名 称: UserController
 * 软件版权: Jones
 * 功能说明：
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/5/20 14:44
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 获取满足条件的用户列表
     * @param user
     * @return 用户列表
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getUserList(User user){
        List<User> userList = userService.selectUser(user);
        return renderSuccess(userList);
    }
}
