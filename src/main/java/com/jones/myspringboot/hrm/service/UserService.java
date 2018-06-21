package com.jones.myspringboot.hrm.service;

import com.jones.myspringboot.hrm.model.User;

import java.util.List;

/**
 * 系统名称: mySpringBoot
 * 模块名称:
 * 类 名 称: UserService
 * 软件版权: Jones
 * 功能说明：用户管理Service层
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/5/20 13:38
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public interface UserService {
    /**
     * 增加用户
     * @param user
     */
    void insertUser(User user);
    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);
    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
    /**
     * 查找用户
     * @param user
     * @return 用户列表
     */
    List<User> selectUser(User user);
}
