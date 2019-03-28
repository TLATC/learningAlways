package com.shawn.learningalways.example.model;

import com.shawn.learningalways.base.model.BaseBean;

/**
 * @ClassName: Example
 * @Description
 * @author: Shawn Wu
 * @date: 2019/3/27 17:32
 * @version:
 */
public class Example extends BaseBean{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

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