package com.shawn.learningalways.hrm.model;

import com.shawn.learningalways.base.model.BaseBean;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: User
 * 软件版权: shawn
 * 功能说明：用户实体类
 * 系统版本：v1.0.1
 * 开发人员: shawn
 * 开发时间: 2018/5/20 14:10
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class User extends BaseBean{

    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 年龄
     */
    private String age;
    /**
     * 性别
     */
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
