package com.jones.learningalways.example.model;

/**
 * 系统名称: learningAlways
 * 模块名称: 测试模块
 * 类 名 称: User
 * 软件版权: Jones
 * 功能说明：用户实体类
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/6/27 20:45
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class User {

    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
