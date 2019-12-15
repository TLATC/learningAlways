package com.shawn.learningalways.login.model;

import com.shawn.learningalways.base.model.BaseBean;

/**
 * @ClassName: Staff
 * @Description 职员
 * @author: Shawn Wu
 * @date: 2019/12/12 19:45
 * @version:
 */
public class Staff extends BaseBean{

    /**
     * 职员id
     */
    private Long staffId;

    /**
     * 职员工号
     */
    private String staffNO;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 0为管理员，1为普通员工
     */
    private Integer staffType;


    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffNO() {
        return staffNO;
    }

    public void setStaffNO(String staffNO) {
        this.staffNO = staffNO;
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

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }
}